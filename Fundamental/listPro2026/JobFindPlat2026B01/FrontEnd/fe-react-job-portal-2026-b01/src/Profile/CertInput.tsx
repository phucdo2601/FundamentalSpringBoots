import React, { useState } from "react";
import { fields } from "../Data/Profile";
import SelectInput from "./SelectInput";
import { Button, Checkbox, Textarea, TextInput } from "@mantine/core";
import { MonthPickerInput } from "@mantine/dates";

interface CertInputProps {
  setEdit?: any;
  add?: any;
}

const CertInput = ({ setEdit, add }: CertInputProps) => {
  const selects = fields;

  const [desc, setDesc] = useState("TEST INPUT");

  // const [startDate, setStartDate] = useState<string | null>();
  // const [endDate, setEndDate] = useState<string | null>(null);

  const [issuerDate, setIssuerDate] = useState<string | null>();

  const [checked, setChecked] = useState<boolean | any>(false);

  return (
    <>
      <div className="flex flex-col gap-3">
        <div className="text-lg font-semibold">
          {add ? "Add Certification" : "Edit Certification"}
        </div>
        <div className="flex gap-10 [&>*]:w-1/2">
          <TextInput withAsterisk label="Title" placeholder="Enter title" />
          <SelectInput props={selects[1]} />
        </div>
        <div className="flex gap-10 [&>*]:w-1/2">
          <MonthPickerInput
            withAsterisk
            maxDate={new Date()}
            label="Issuer Date"
            placeholder="Pick Date"
            value={issuerDate}
            onChange={setIssuerDate}
          />

          <TextInput
            withAsterisk
            label="Certification id"
            placeholder="Cert ID"
          />
        </div>

        <div className="flex gap-5">
          <Button
            color="brightSun.4"
            variant="outline"
            onClick={() => setEdit(false)}
          >
            Save
          </Button>
          <Button color="red.8" variant="light" onClick={() => setEdit(false)}>
            Cancel
          </Button>
        </div>
      </div>
    </>
  );
};

export default CertInput;
