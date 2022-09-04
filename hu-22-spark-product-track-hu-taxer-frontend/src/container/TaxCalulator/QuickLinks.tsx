import * as React from "react";
import ListItem from "@mui/material/ListItem";
import ListItemButton from "@mui/material/ListItemButton";
import ListItemText from "@mui/material/ListItemText";
import { FixedSizeList, ListChildComponentProps } from "react-window";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";

function renderRow(props: ListChildComponentProps) {
  const { index, style } = props;

  return (
    <ListItem style={style} key={index} component="div" disablePadding>
      <ListItemButton>
        <ListItemText primary={`Item ${index + 1}`} />
        <p>hi</p>
      </ListItemButton>
    </ListItem>
  );
}

export default function QuickLinks() {
  return (
    <div>
      <h2>Quick Links</h2>

      <Card
        style={{
          maxWidth: 250,
        }}
      >
        <CardContent>
          <FixedSizeList
            height={400}
            width={360}
            itemSize={46}
            itemCount={15}
            overscanCount={5}
          >
            {renderRow}
          </FixedSizeList>
        </CardContent>
      </Card>
    </div>
  );
}
