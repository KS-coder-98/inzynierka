import * as React from "react";
import Paper from "@material-ui/core/Paper";
import LinearProgress from "@material-ui/core/LinearProgress";
import { withStyles } from "@material-ui/core/styles";
import {
  ViewState,
  EditingState,
  IntegratedEditing,
} from "@devexpress/dx-react-scheduler";
import {
  Scheduler,
  WeekView,
  DayView,
  Appointments,
  Toolbar,
  DateNavigator,
  ViewSwitcher,
  AppointmentForm,
  AppointmentTooltip,
  TodayButton,
} from "@devexpress/dx-react-scheduler-material-ui";
import { useParams } from "react-router-dom";

import { getTokenFromStorage } from "../../handlerToLocalStorage";
import { addReservation, deleteReservation } from "../event/EventHelper";

const ReservationPage = () => {
  // Get ID from URL
  const conferenceRoomId = useParams().id;

  const [fetchData, setFetchData] = React.useState(0);
  const [roomName, setRoomName] = React.useState("");
  const getData = (setData, setLoading) => {
    const url = "http://localhost:8080/conference-room/" + conferenceRoomId;

    setLoading(true);
    const token = getTokenFromStorage();

    return fetch(url, {
      headers: {
        "Content-type": "application/json; charset=UTF-8",
        Authorization: token,
      },
    })
      .then((response) => response.json())
      .then((data) => {
        setTimeout(() => {
          setData(data.reservations);
          setRoomName(data.name);
          setLoading(false);
        }, 600);
      });
  };

  const styles = {
    toolbarRoot: {
      position: "relative",
    },
    progress: {
      position: "absolute",
      width: "100%",
      bottom: 0,
      left: 0,
    },
  };

  const ToolbarWithLoading = withStyles(styles, { name: "Toolbar" })(
    ({ children, classes, ...restProps }) => (
      <div className={classes.toolbarRoot}>
        <Toolbar.Root {...restProps}>{children}</Toolbar.Root>
        <LinearProgress className={classes.progress} />
      </div>
    )
  );

  const usaTime = (date) =>
    new Date(date).toLocaleString("en-US", { timeZone: "America/Los_Angeles" });

  const mapAppointmentData = (appointment) => ({
    title: appointment.name,
    startDate: new Date(Date.parse(appointment.startTime)),
    endDate: new Date(Date.parse(appointment.endTime)),
    id: appointment.id,
  });

  const initialState = {
    data: [],
    loading: false,
    currentDate: "2021-11-23",
    currentViewName: "Week",
  };

  const reducer = (state, action) => {
    switch (action.type) {
      case "setLoading":
        return { ...state, loading: action.payload };
      case "setData":
        return { ...state, data: action.payload.map(mapAppointmentData) };
      case "setCurrentViewName":
        return { ...state, currentViewName: action.payload };
      case "setCurrentDate":
        return { ...state, currentDate: action.payload };
      default:
        return state;
    }
  };

  const [state, dispatch] = React.useReducer(reducer, initialState);
  const { data, loading, currentViewName, currentDate } = state;
  const setCurrentViewName = React.useCallback(
    (nextViewName) =>
      dispatch({
        type: "setCurrentViewName",
        payload: nextViewName,
      }),
    [dispatch]
  );
  const setData = React.useCallback(
    (nextData) =>
      dispatch({
        type: "setData",
        payload: nextData,
      }),
    [dispatch]
  );
  const setCurrentDate = React.useCallback(
    (nextDate) =>
      dispatch({
        type: "setCurrentDate",
        payload: nextDate,
      }),
    [dispatch]
  );
  const setLoading = React.useCallback(
    (nextLoading) =>
      dispatch({
        type: "setLoading",
        payload: nextLoading,
      }),
    [dispatch]
  );

  React.useEffect(() => {
    getData(setData, setLoading);
  }, [setData, currentViewName, currentDate, fetchData]);

  const commitChanges = ({ added, changed, deleted }) => {
    if (added) {
      const newReservation = {
        name: added.title,
        startTime: added.startDate,
        endTime: added.endDate,
      };
      addReservation(conferenceRoomId, newReservation);
      // console.log(newReservation);
      setTimeout(() => setFetchData(fetchData + 1), 200);
    }
    if (changed) {
      console.log(changed);
    }
    if (deleted) {
      deleteReservation(deleted);
      setTimeout(() => setFetchData(fetchData + 1), 200);
    }
  };

  const BasicLayout = ({ onFieldChange, appointmentData, ...restProps }) => {
    const onCustomFieldChange = (nextValue) => {
      onFieldChange({ customField: nextValue });
    };

    return (
      <AppointmentForm.BasicLayout
        appointmentData={appointmentData}
        onFieldChange={onFieldChange}
        {...restProps}
      >
        <AppointmentForm.Label text="Custom Field" type="title" />
        <AppointmentForm.TextEditor
          value={appointmentData.customField}
          onValueChange={onCustomFieldChange}
          placeholder="Custom field"
        />
      </AppointmentForm.BasicLayout>
    );
  };

  const TextEditor = (props) => {
    // eslint-disable-next-line react/destructuring-assignment
    if (props.type === "multilineTextEditor") {
      return null;
    }
    return <AppointmentForm.TextEditor {...props} />;
  };
  const messages = {
    moreInformationLabel: "",
  };

  return (
    <Paper>
      <h2>Grafik dla: {roomName}</h2>
      <Scheduler data={data}>
        <ViewState
          currentDate={currentDate}
          currentViewName={currentViewName}
          onCurrentViewNameChange={setCurrentViewName}
          onCurrentDateChange={setCurrentDate}
        />
        <EditingState onCommitChanges={commitChanges} />
        <IntegratedEditing />
        <DayView startDayHour={7.5} endDayHour={17.5} />
        <WeekView startDayHour={7.5} endDayHour={17.5} />
        <Appointments />
        <Toolbar
          {...(loading ? { rootComponent: ToolbarWithLoading } : null)}
        />
        <DateNavigator />
        <TodayButton />
        <ViewSwitcher />
        <AppointmentTooltip showOpenButton showCloseButton />
        <AppointmentForm textEditorComponent={TextEditor} messages={messages} />
      </Scheduler>
    </Paper>
  );
};

export default ReservationPage;
