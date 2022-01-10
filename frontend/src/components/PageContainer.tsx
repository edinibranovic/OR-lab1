import React from "react";
import { Helmet } from "react-helmet";

type ContainerProps = {
  children: React.ReactNode;
};
export default function PageContainer({ children }: ContainerProps) {
  return (
    <div className="flex justify-start flex-col items-center flex-grow">
      <Helmet>
        <title>Movies Dataset</title>
        <meta charSet="utf-8" />
        <meta
          name="Description"
          content="OBUCA LAB4"
        />
        <meta name="Keywords" content="JSON, CSV, database" />
        <meta name="Author" content="Edin Ibranović" />
      </Helmet>
      {children}
    </div>
  );
}
