import { createBrowserRouter } from "react-router-dom";
import HomePage from "../pages/HomePage";
import SignInPage from "../pages/SignInPage";
import GeneralRolePage from "../pages/GeneralRole/generalRolePage";

export const routerList = createBrowserRouter([
  {
    path: "/",
    element: <HomePage />,
  },

  {
    path: "/sign-in",
    element: <SignInPage />,
  },
  {
    path: "/general-roles",
    element: <GeneralRolePage />,
  },
]);
