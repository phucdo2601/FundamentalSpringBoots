const signUpValidation = (name: string, value: string) => {
  switch (name) {
    case "name":
      if (value.length === 0) {
        return "Name is required.";
      }
      return "";
    case "email":
      if (value.length === 0) {
        return "Email is required.";
      }
      if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value)) {
        return "Email is invalid";
      }
      return "";

    case "password":
      if (value.length === 0) {
        return "Password is required.";
      }
      if (
        !/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&.#_\-])[A-Za-z\d@$!%*?&.#_\-]{8,15}$/.test(
          value,
        )
      ) {
        return "Password must be 8-15 characters with an uppercase, a lowercase, a number, and a special character!";
      }
      return "";
    default:
      return "";
  }
};

const loginValidation = (name: string, value: string) => {
  switch (name) {
    case "name":
      if (value.length === 0) {
        return "Name is required.";
      }
      return "";
    case "email":
      if (value.length === 0) {
        return "Email is required.";
      }

      return "";

    case "password":
      if (value.length === 0) {
        return "Password is required.";
      }

      return "";
    default:
      return "";
  }
};

export { signUpValidation, loginValidation };
