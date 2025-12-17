const { create } = require("zustand");

const usePostStore = create((set, get) => ({
    posts: [],
    loading: false,
    error: null,
}));