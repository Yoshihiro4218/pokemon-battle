import Vue from 'vue'
import Router from 'vue-router'
import Home from './index'
import Test from '../views/TestView'

Vue.use(Router)

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/test',
            name: 'test',
            component: Test
        },
    ]
})