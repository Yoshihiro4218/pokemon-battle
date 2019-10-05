import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import Test from '../views/TestView'
import PokeList from '../views/PokeListView'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/login',
            name: 'login',
            component: Login
        },
        {
            path: '/test',
            name: 'test',
            component: Test
        },
        {
            path: '/pokeList',
            name: 'pokeList',
            component: PokeList
        },
    ]
})