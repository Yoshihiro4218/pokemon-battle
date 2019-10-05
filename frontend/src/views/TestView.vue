<template>
    <div class="test">
        <div id="cart" style="display: none;"></div>
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcQYvUFoWaWMbHG9--4QFgqrZJs68lJNE-0sNyLfhKtbdRHQlW7L"><br>
        {{price | moneyDelemiter}}円
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        data() {
            return {
                items: [],
                price: 123456,
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
            showCommodityDetail() {
            },
        }
    }
</script>

<style scoped>


</style>