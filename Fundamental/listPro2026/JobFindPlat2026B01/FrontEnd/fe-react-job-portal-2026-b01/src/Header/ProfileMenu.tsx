import React, { useState } from "react";
import { Menu, Button, Text, Avatar, Switch } from "@mantine/core";
import {
  IconArrowsLeftRight,
  IconFileText,
  IconLogout2,
  IconMessageCircle,
  IconMoon,
  IconSun,
  IconTrash,
  IconUserCircle,
} from "@tabler/icons-react";
import { Link } from "react-router-dom";

const ProfileMenu = () => {
  const [checked, setChecked] = useState<boolean>(false);

  const [opened, setOpened] = useState(false);

  return (
    <>
      <Menu shadow="md" width={200} opened={opened} onChange={setOpened}>
        <Menu.Target>
          <div className="flex items-center gap-2 cursor-pointer">
            <div className="">Marshall</div>
            <Avatar src="avatar.png" alt="it's me" />
          </div>
        </Menu.Target>

        <Menu.Dropdown onChange={() => setOpened(true)}>
          <Link to={`/profile`}>
            <Menu.Item leftSection={<IconUserCircle size={14} />}>
              Profile
            </Menu.Item>
          </Link>
          <Menu.Item leftSection={<IconMessageCircle size={14} />}>
            Messages
          </Menu.Item>
          <Menu.Item leftSection={<IconFileText size={14} />}>Resume</Menu.Item>
          <Menu.Item
            leftSection={<IconMoon size={14} />}
            rightSection={
              <>
                <Switch
                  size="md"
                  color="dark.4"
                  onLabel={<IconSun size={16} color="yellow" />}
                  offLabel={<IconMoon size={16} color="cyan" />}
                  checked={checked}
                  onChange={(event) => setChecked(event.currentTarget.checked)}
                />
              </>
            }
          >
            Dark Mode
          </Menu.Item>

          <Menu.Divider />

          <Menu.Item color="red" leftSection={<IconLogout2 size={14} />}>
            Log out
          </Menu.Item>
        </Menu.Dropdown>
      </Menu>
    </>
  );
};

export default ProfileMenu;
