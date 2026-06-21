import {
  Button,
  Modal,
  PasswordInput,
  PinInput,
  rem,
  TextInput,
} from "@mantine/core";
import { IconAt, IconLock } from "@tabler/icons-react";
import React, { useState } from "react";
import { changePassword, sendOtp, verifyOtp } from "../Services/UserService";
import { signUpValidation } from "../Services/FormValidation";
import {
  errorNotification,
  successNotification,
} from "../Services/NotificationService";
import { useInterval } from "@mantine/hooks";

const ResetPassword = (props: any) => {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [passErr, setPassErr] = useState("");
  const [otpSent, setOtpSent] = useState(false);
  const [otpSending, setOtpSending] = useState(false);
  const [verified, setVerified] = useState(false);
  const [resendLoader, setResendLoader] = useState(false);
  const [seconds, setSeconds] = useState(60);
  const interval = useInterval(() => {
    if (seconds === 0) {
      setResendLoader(false);
      setSeconds(60);
      interval.stop();
    } else {
      setSeconds((s) => s - 1);
    }
  }, 1000);

  const handleSendOtp = () => {
    setOtpSending(true);
    sendOtp(email)
      .then((res) => {
        console.log(res.data);
        successNotification("OTP sent successfully!", "Enter OTP to reset.");
        setOtpSent(true);
        setOtpSending(false);
        setResendLoader(true);
        interval.start();
      })
      .catch((err) => {
        console.log(err);
        setOtpSending(false);
        errorNotification("OTP sending Failed", err.response.data.errorMessage);
      });
  };

  const handleVerifyOtp = (otp: string) => {
    verifyOtp(email, otp)
      .then((res) => {
        console.log(res);
        successNotification("OTP verified!", "Enter new password.");
        setVerified(true);
      })
      .catch((err) => {
        console.log(err);
        errorNotification(
          "OTP Verification Failed",
          err.response.data.errorMessage,
        );
      });
  };

  const reSendOtp = () => {
    if (resendLoader) {
      return;
    }
    handleSendOtp();
  };

  const changeEmail = () => {
    setOtpSent(false);
    setResendLoader(false);
    setSeconds(60);
    setVerified(false);
    interval.stop();
  };

  const handleResetPassword = () => {
    changePassword(email, password)
      .then((res) => {
        console.log(res);
        successNotification("Password changed!", "Login with new password.");
        props.close();
      })
      .catch((err) => {
        console.log(err);
        errorNotification(
          "Password Reset Failed!",
          err.response.data.errorMessage,
        );
      });
  };

  return (
    <>
      <Modal opened={props.opened} onClose={props.close} title="Reset Password">
        <div className="flex flex-col gap-6">
          <TextInput
            withAsterisk
            leftSection={
              <IconAt
                style={{
                  width: rem(16),
                  height: rem(16),
                }}
              />
            }
            label="Your Email"
            placeholder="Your Email"
            name="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            rightSection={
              <>
                <Button
                  loading={otpSending && !otpSent}
                  size="xs"
                  className="mr-1"
                  autoContrast
                  disabled={email === "" || otpSent}
                  variant="filled"
                  onClick={handleSendOtp}
                >
                  Log In
                </Button>
              </>
            }
            rightSectionWidth={"xl"}
          />

          {otpSent && (
            <>
              <PinInput
                length={6}
                onComplete={handleVerifyOtp}
                className="mx-auto"
                type={"number"}
              />
            </>
          )}

          {otpSent && !verified && (
            <>
              <div
                className="
                flex gap-2
              "
              >
                <Button
                  loading={otpSending}
                  size="xs"
                  autoContrast
                  variant="light"
                  color="brightSun.4"
                  fullWidth
                  onClick={reSendOtp}
                >
                  {resendLoader ? seconds : "Resend"}
                </Button>

                <Button
                  size="xs"
                  className="mr-1"
                  autoContrast
                  variant="filled"
                  fullWidth
                  onClick={changeEmail}
                >
                  Change Email
                </Button>
              </div>
            </>
          )}
          {verified && (
            <>
              <PasswordInput
                leftSection={
                  <IconLock
                    style={{
                      width: rem(18),
                      height: rem(18),
                    }}
                    stroke={1.5}
                  />
                }
                label="Password"
                placeholder="Password"
                name="password"
                value={password}
                onChange={(e) => {
                  setPassword(e.target.value);
                  setPassErr(signUpValidation(e.target.name, e.target.value));
                }}
                error={passErr}
              />
            </>
          )}
          {verified && (
            <>
              <Button
                size="xs"
                className="mr-1"
                autoContrast
                variant="filled"
                fullWidth
                onClick={handleResetPassword}
              >
                Change Password
              </Button>
            </>
          )}
        </div>
      </Modal>
    </>
  );
};

export default ResetPassword;
