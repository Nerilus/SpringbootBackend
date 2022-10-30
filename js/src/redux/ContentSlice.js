import { createSlice } from "@reduxjs/toolkit";

export const contentsSlice = createSlice({
  name: "contents",
  initialState: {
    contents: null,
  },
  reducers: {
    setContentsData: (state, { payload }) => {
      state.contents = payload;
    },
    addContent: (state,{ payload }) => {
      state.contents.push(payload);
    },
    deleteContent: (state,{ payload }) => {
      state.contents = state.contents.filter((content) => content.id !== payload);
    },
  },
});

export const { setContentsData, addContent, deleteContent } =
  contentsSlice.actions;
export default contentsSlice.reducer;
