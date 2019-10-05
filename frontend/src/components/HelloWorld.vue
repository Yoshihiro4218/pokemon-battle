<template>
    <div class="hello">
        <h1>{{ msg }}</h1>
        <router-link to="/test">Go to Test</router-link><br>
        <router-link to="/pokeList">Go to pokeList</router-link><br>
        <router-link to="/login">Go to login</router-link><br>

    </div>
</template>

<script>
    export default {
        name: 'HelloWorld',
        props: {
            msg: String
        }
    }
</script>

<style scoped>

</style>
