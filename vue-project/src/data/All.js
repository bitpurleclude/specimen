import { createStore } from 'vuex';


export default new createStore({
  state: {
    globalVar: false,
  },
  getters: {
    getGlobalVar: state => state.globalVar,
  },
  mutations: { 
    setGlobalVar: (state, value) => {
      state.globalVar = value;
    },
  },
});