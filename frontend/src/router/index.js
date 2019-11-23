import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/LoginView'
import Test from '../views/TestView'
import PokeList from '../views/PokeListView'
import TrainerList from '../views/TrainerListView'
import MyPokeList from '../views/MyPokeListView'
import UserRegisterForm from '../views/UserRegisterForm'
import TrainerRegisterForm from '../views/TrainerRegisterForm'

Vue.use(Router);

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
        {
            path: '/trainerList',
            name: 'trainerList',
            component: TrainerList
        },
        {
            path: '/myPokeList',
            name: 'myPokeList',
            component: MyPokeList
        },
        {
            path: '/userRegisterForm',
            name: 'userRegisterForm',
            component: UserRegisterForm
        },
        {
            path: '/trainerRegisterForm',
            name: 'trainerRegisterForm',
            component: TrainerRegisterForm
        },
    ]
})