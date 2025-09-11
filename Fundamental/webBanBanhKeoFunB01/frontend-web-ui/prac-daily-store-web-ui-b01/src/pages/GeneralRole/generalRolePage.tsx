import { Box } from "@mui/material";
import { DataGrid, GridColDef } from "@mui/x-data-grid";
import React, { useEffect, useState } from "react";
import { GeneralRoleResDto } from "../../models/response/GeneralRoleResDto";
import GeneralRoleApi from "../../api/GeneralRoleApi";

const columns: GridColDef[] = [
  {
    field: "id",
    headerName: "ID",
    width: 70,
  },

  {
    field: "genRoleCode",
    headerName: "Role Code",
    width: 70,
  },

  {
    field: "genRoleTitle",
    headerName: "Role Title",
    width: 70,
  },
];

const GeneralRolePage = () => {
  const [listGenRole, setListGenRole] = useState<GeneralRoleResDto[]>([]);

  const getAllGenRoles = async () => {
    await GeneralRoleApi.getAllGeneralRolesList()
      .then((res) => {
        setListGenRole(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    getAllGenRoles();
  }, []);

  return (
    <>
      <Box sx={{ height: 400, width: "100%" }}>
        <DataGrid
          rows={listGenRole}
          columns={columns}
          initialState={{
            pagination: {
              paginationModel: {
                pageSize: 5,
              },
            },
          }}
          pageSizeOptions={[5]}
          checkboxSelection
          disableRowSelectionOnClick
        />
      </Box>
    </>
  );
};

export default GeneralRolePage;
