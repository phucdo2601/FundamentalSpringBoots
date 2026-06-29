import {
  Anchor,
  Button,
  Checkbox,
  Group,
  LoadingOverlay,
  PasswordInput,
  Radio,
  rem,
  TextInput,
} from "@mantine/core";
import { IconAt, IconCheck, IconLock, IconX } from "@tabler/icons-react";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { registerUser } from "../Services/UserService";
import { signUpValidation } from "../Services/FormValidation";
import { notifications } from "@mantine/notifications";
import { errorNotification } from "../Services/NotificationService";

const form = {
  name: "",
  email: "",
  password: "",
  confirmPassword: "",
  accountType: "APPLICANT",
};

const SignUpComp = () => {
  const [data, setData] = useState<{ [key: string]: string }>(form);

  const [formError, setFormError] = useState<{ [key: string]: string }>(form);

  const [loading, setLoading] = useState(false);

  const navigate = useNavigate();

  const handleChange = (event: any) => {
    // console.log(event.target.value);
    if (typeof event === "string") {
      setData({ ...data, accountType: event });
      return;
    }

    let name = event.target.name;

    let value = event.target.value;

    setData({ ...data, [event.target.name]: event.target.value });
    setFormError({
      ...formError,
      [name]: signUpValidation(name, value),
    });

    if (name === "password" && data.confirmPassword !== "") {
      let err = "";
      if (data.confirmPassword !== value) {
        err = "Password do not match.";
      }
      setFormError({
        ...formError,
        [name]: signUpValidation(name, value),
        confirmPassword: err,
      });
    }

    if (name === "confirmPassword") {
      if (data.password !== value) {
        setFormError({
          ...formError,
          [name]: "Password do not match.",
        });
      } else {
        setFormError({
          ...formError,
          confirmPassword: "",
        });
      }
    }
  };

  const handleSubmit = (event: any) => {
    let valid = true;
    let newFormError: {
      [key: string]: string;
    } = {};
    for (let key in data) {
      if (key === "accountType") {
        continue;
      }

      if (key !== "confirmPassword") {
        newFormError[key] = signUpValidation(key, data[key]);
      } else if (data[key] !== data["password"]) {
        newFormError[key] = "Password do not match.";
      }

      if (newFormError[key]) {
        valid = false;
      }
    }

    setFormError(newFormError);

    if (valid === true) {
      setLoading(true);
      registerUser(data)
        .then((res) => {
          console.log(res.data);
          setData(form);
          notifications.show({
            title: "Registered Successfully",
            message: "Redirecting to Login page...",
            withCloseButton: true,
            icon: (
              <IconCheck
                style={{
                  width: "90%",
                  height: "90%",
                }}
              />
            ),

            color: "teal",
            withBorder: true,
            className: "!bordder-green-500",
          });

          setTimeout(() => {
            setLoading(false);
            navigate("/login");
          }, 4000);
        })
        .catch((err) => {
          setLoading(false);
          console.log(err);
          // notifications.show({
          //   title: "Registered Failed!",
          //   message: err.response.data.errorMessage,
          //   withCloseButton: true,
          //   icon: (
          //     <IconX
          //       style={{
          //         width: "90%",
          //         height: "90%",
          //       }}
          //     />
          //   ),

          //   color: "red",
          //   withBorder: true,
          //   className: "!bordder-green-500",
          // });
          errorNotification(
            "Registration Failed!",
            err.response.data.errorMessage,
          );
        });
    }
  };

  return (
    <>
      <LoadingOverlay
        visible={loading}
        zIndex={1000}
        className="translate-x-1/2"
        overlayProps={{ radius: "sm", blur: 2 }}
        loaderProps={{ color: "brightSun.4", type: "bars" }}
      />
      <div className="w-1/2 px-20 flex flex-col justify-center gap-1">
        <div className="text-2xl font-semibold">Create Account</div>
        <TextInput
          withAsterisk
          label="Full Name"
          placeholder="Your name"
          name="name"
          value={data.name}
          onChange={(e) => handleChange(e)}
          error={formError.name}
        />
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
          value={data.email}
          onChange={(e) => handleChange(e)}
          error={formError.email}
        />
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
          value={data.password}
          onChange={handleChange}
          error={formError.password}
        />

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
          label="Confirm Password"
          placeholder="Confirm Password"
          name="confirmPassword"
          value={data.confirmPassword}
          onChange={handleChange}
          error={formError.confirmPassword}
        />

        <Radio.Group
          value={data.accountType}
          onChange={handleChange}
          label="You are?"
          withAsterisk
        >
          <Group mt={`xs`}>
            <Radio
              className="px-6 py-4 border
              hover:bg-mine-shaft-500
              has-[:checked]:bg-bright-sun-400/5
                has-[:checked]:border-bright-sun-400
              border-mine-shaft-600 rounded-lg"
              autoContrast
              value="APPLICANT"
              label="APPLICANT"
            />
            <Radio
              className="px-6 py-4 border
              hover:bg-mine-shaft-500
              has-[:checked]:bg-bright-sun-400/5
                has-[:checked]:border-bright-sun-400
              border-mine-shaft-600 rounded-lg"
              autoContrast
              value="EMPLOYER"
              label="EMPLOYER"
            />
          </Group>
        </Radio.Group>

        <Checkbox
          autoContrast
          label={
            <>
              I accept <Anchor>terms & conditions</Anchor>
            </>
          }
        />

        <Button
          loading={loading}
          autoContrast
          variant="filled"
          onClick={handleSubmit}
        >
          Sign Up
        </Button>

        <div className="mx-auto">
          Have and account?{" "}
          <span
            className="text-bright-sun-400 hover:underline"
            onClick={() => {
              navigate("/login");
              setFormError(form);
              setData(form);
            }}
          >
            Login
          </span>
        </div>
      </div>
    </>
  );
};

export default SignUpComp;
