<template>
    <div id="app">
        <Header msg="Header"/>
        <img alt="Dragon" src="./assets/logo.png" width="300px">
        <router-view/>
        <HelloWorld msg="Welcome to PokemonBattle!" style="margin-top: 200px;"/>
    </div>
</template>

<script>
    import HelloWorld from './components/HelloWorld.vue'
    import Header from './components/Header.vue'

    export default {
        name: 'app',
        components: {
            Header,
            HelloWorld,
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
