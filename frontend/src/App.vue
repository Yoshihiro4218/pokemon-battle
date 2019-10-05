<template>
    <div id="app">
        <Header msg="Header"/>
        <img alt="Dragon" src="./assets/logo.png" width="300px">
        <div class="contents">
        <router-view/>
        </div>
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
        background-color: rgba(195,249,255,0.31);
    }
    .contents {
        padding: 40px;
        margin: 20px auto 30px auto;
        position: relative;
        box-sizing: border-box;
        display: block;
        background-color: white;
        width: 1200px;
        border-style: solid;
        border-color: whitesmoke;
        border-width: thin;
        box-shadow: 0 2px 5px 0 rgba(0,0,0,.1);
    }
</style>
