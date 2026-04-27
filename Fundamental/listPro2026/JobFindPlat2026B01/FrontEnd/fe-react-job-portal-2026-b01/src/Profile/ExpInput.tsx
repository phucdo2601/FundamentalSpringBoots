import React, { useState } from "react";
import { fields } from "../Data/Profile";
import SelectInput from "./SelectInput";
import { Button, Checkbox, Textarea } from "@mantine/core";
import { MonthPickerInput } from "@mantine/dates";

interface ExpInputProps {
  setEdit?: any;
  add?: any;
}

const ExpInput = ({ setEdit, add }: ExpInputProps) => {
  const selects = fields;

  const [desc, setDesc] = useState("TEST INPUT");

  const [startDate, setStartDate] = useState<string | null>();
  const [endDate, setEndDate] = useState<string | null>(null);

  const [checked, setChecked] = useState<boolean | any>(false);

  return (
    <>
      <div className="flex flex-col gap-3">
        <div className="text-lg font-semibold">
          {add ? "Add Experience" : "Edit Experience"}
        </div>
        <div className="flex gap-10 [&>*]:w-1/2">
          <SelectInput props={selects[0]} />
          <SelectInput props={selects[1]} />
        </div>

        <SelectInput props={selects[2]} />
        <Textarea
          label={"Summary"}
          value={desc}
          autosize
          minRows={2}
          placeholder="Enter summary..."
          onChange={(event) => setDesc(event.currentTarget.value)}
        />
        <div className="flex gap-10 [&>*]:w-1/2">
          <MonthPickerInput
            withAsterisk
            maxDate={endDate || undefined}
            label="Start Date"
            placeholder="Pick Date"
            value={startDate}
            onChange={setStartDate}
          />

          <MonthPickerInput
            withAsterisk
            maxDate={new Date()}
            label="End Date"
            placeholder="Pick Date"
            value={endDate}
            onChange={setEndDate}
          />
        </div>
        <Checkbox
          autoContrast
          label="Currently working here"
          value={checked}
          onChange={(e) => setChecked(e.currentTarget.checked)}
        />
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

export default ExpInput;
