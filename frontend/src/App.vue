<template>
    <div id="app">
        <Header msg="Header"/>
        <img alt="Vue logo" src="./assets/logo.png">
        <router-view/>
        <HelloWorld msg="Welcome to Your Vue.js App"/>
        <Test msg="Pokemon"/>
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'
    import Test from './components/Test.vue'
    import Header from './components/Header.vue'

    export default {
        name: 'app',
        components: {
            Header,
            HelloWorld,
            Test
        }
    }
</script>

<style>
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 0px;
    }
</style>
