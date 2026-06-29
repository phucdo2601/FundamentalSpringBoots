import React from "react";
import {
  IconAnchor,
  IconAsset,
  IconBell,
  IconSettings,
} from "@tabler/icons-react";
import { Avatar, Button, Indicator } from "@mantine/core";
import NavLinks from "./NavLinks";
import { Link, useLocation } from "react-router-dom";
import ProfileMenu from "./ProfileMenu";
import { useSelector } from "react-redux";

const Header = () => {
  const user = useSelector((state: any) => state.user);

  const location = useLocation();
  return (
    <>
      {location.pathname !== "/signup" && location.pathname !== "/login" ? (
        <>
          <div
            className="w-full bg-mine-shaft-600 px-6 text-white h-28 flex justify-between items-center
       font-['poppins']"
          >
            <div className="flex gap-1 items-center text-bright-sun-400">
              <IconAnchor className="h-8 w-8" stroke={2.5} />
              <div className="text-2xl font-semibold">iJobs</div>
            </div>
            <NavLinks />
            <div className="flex gap-5 items-center">
              {user ? (
                <>
                  <ProfileMenu />
                </>
              ) : (
                <>
                  <Link to={`/login`}>
                    <Button variant="subtle" color="brightSun.4">
                      Login
                    </Button>
                  </Link>
                </>
              )}

              {/* <div className="bg-mine-shaft-900 p-1.5 rounded-full ">
                <IconSettings stroke={1.5} />
              </div> */}
              <div className="bg-mine-shaft-900 p-1.5 rounded-full ">
                <Indicator color="brightSun.4" offset={6} size={9} processing>
                  <IconBell stroke={1.5} />
                </Indicator>
              </div>
            </div>
          </div>
        </>
      ) : (
        <></>
      )}
    </>
  );
};

export default Header;
