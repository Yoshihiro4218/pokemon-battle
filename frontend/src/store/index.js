import Vue from 'vue';
import Vuex from 'vuex';
Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        searchQuery: ""
    },
    mutations: {
        setSearchQuery(state, data) {
            state.searchQuery = data
        }
    },
    actions: {
        setSearchQuery({ commit }, data) {
            commit('setSearchQuery', data);
        },
    },
});
