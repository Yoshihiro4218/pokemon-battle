<template>
    <div class="hello">
        <h1>{{ msg }}</h1>
        <router-link class="routerLink" to="/test">Go to Test<br></router-link>
        <router-link class="routerLink" to="/pokeList">Go to pokeList<br></router-link>
        <router-link class="routerLink" to="/login">Go to login<br></router-link>
        <router-link class="routerLink" to="/trainerList">Go to trainerList<br></router-link>

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
    .routerLink {
        font-size: 20px;
    }

</style>
