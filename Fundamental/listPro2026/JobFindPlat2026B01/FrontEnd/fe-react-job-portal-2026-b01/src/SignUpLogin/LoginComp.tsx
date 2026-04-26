import {
  Anchor,
  Button,
  Checkbox,
  PasswordInput,
  rem,
  TextInput,
} from "@mantine/core";
import { IconAt, IconLock } from "@tabler/icons-react";
import React from "react";
import { Link } from "react-router-dom";

const LoginComp = () => {
  return (
    <>
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
        />

        <Button autoContrast variant="filled">
          Sign Up
        </Button>

        <div className="mx-auto">
          Don't Have and account?{" "}
          <Link to={`/signup`} className="text-bright-sun-400">
            Signup
          </Link>
        </div>
      </div>
    </>
  );
};

export default LoginComp;
