import {
  Anchor,
  Button,
  Checkbox,
  LoadingOverlay,
  PasswordInput,
  rem,
  TextInput,
} from "@mantine/core";
import { IconAt, IconCheck, IconLock, IconX } from "@tabler/icons-react";
import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { loginUser } from "../Services/UserService";
import { loginValidation } from "../Services/FormValidation";
import { notifications } from "@mantine/notifications";
import { useDisclosure } from "@mantine/hooks";
import ResetPassword from "./ResetPassword";
import { useDispatch } from "react-redux";
import { setUser } from "../ReduxConfig/Slices/UserSlice";

const form = {
  email: "",
  password: "",
};

const LoginComp = () => {
  const [loading, setLoading] = useState(false);

  const dispatch = useDispatch();
  const [data, setData] = useState<{ [key: string]: string }>(form);
  const [formError, setFormError] = useState<{ [key: string]: string }>(form);
  const [opened, { open, close }] = useDisclosure(false);
  const navigate = useNavigate();

  const handleChange = (event: any) => {
    setFormError({
      ...formError,
      [event.target.name]: "",
    });
    setData({
      ...data,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = (event: any) => {
    let valid = true;
    let newFormError: {
      [key: string]: string;
    } = {};
    for (let key in data) {
      newFormError[key] = loginValidation(key, data[key]);

      if (newFormError[key]) {
        valid = false;
      }
    }

    setFormError(newFormError);

    if (valid) {
      setLoading(true);
      loginUser(data)
        .then((res) => {
          console.log(res.data);

          notifications.show({
            title: "Login Successfully",
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
            dispatch(setUser(res));
            navigate("/");
          }, 4000);
        })
        .catch((err) => {
          console.log(err.response.data);
          setLoading(false);

          notifications.show({
            title: "Login Failed!",
            message: err.response.data.errorMessage,
            withCloseButton: true,
            icon: (
              <IconX
                style={{
                  width: "90%",
                  height: "90%",
                }}
              />
            ),

            color: "red",
            withBorder: true,
            className: "!bordder-green-500",
          });
        });
    }
  };

  return (
    <>
      <LoadingOverlay
        visible={loading}
        zIndex={1000}
        overlayProps={{ radius: "sm", blur: 2 }}
        loaderProps={{ color: "brightSun.4", type: "bars" }}
      />
      <div className="w-1/2 px-20 flex flex-col justify-center">
        <div className="text-2xl font-semibold">Sign In</div>
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
          onChange={handleChange}
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

        <Button
          loading={loading}
          autoContrast
          variant="filled"
          onClick={handleSubmit}
        >
          Log In
        </Button>

        <div className="mx-auto">
          Don't Have and account?{" "}
          <span
            className="text-bright-sun-400 hover:underline cursor-pointer"
            onClick={() => {
              navigate("/signup");
              setFormError(form);
              setData(form);
            }}
          >
            Signup
          </span>
        </div>
        <div
          onClick={open}
          className="text-bright-sun-400 hover:underline cursor-pointer text-center"
        >
          Forget Password?
        </div>
      </div>
      <ResetPassword opened={opened} close={close} />
    </>
  );
};

export default LoginComp;
