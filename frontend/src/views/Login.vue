<template>
<div class="loginDiv">
    <h2>LoginForm!!</h2>

    <form action="/login" method="post">
        <input type="text" name="email">email
        <br/>
        <input type="password" name="password">password

        <br/>

        <input type="submit" value="Login">
    </form>
</div>
</template>

<script>
    export default {
        name: "Login",
        data() {
            return {
                items: [],
            }
        },
        components: {},
        computed: {},
        watch: {
            items() {
            }
        },
        mounted() {

        },
        methods: {
        }
    }
</script>

<style scoped>
    .loginDiv {
        width: 1300px;
        text-align: center;
        position: relative;
        display: block;
        box-sizing: border-box;
        margin-right: auto;
        margin-left: auto;
    }

</style>