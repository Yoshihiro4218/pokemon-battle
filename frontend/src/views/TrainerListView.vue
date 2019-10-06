<template>
<div class="trainerListDiv">
<!--            <div class="pokeImgDiv" v-for="imgUrl of imgUrls" v-bind:key="imgUrls">-->
<!--                <img alt="pokemon" class="pokeImg" v-bind:src="imgUrl">-->
<!--            </div>-->
</div>
</template>

<script>
    import axios from 'axios'
    import store from '../store/index.js'
    import { mapState } from 'vuex'

    export default {
        name: "TrainerListView",
        data() {
            return {
                items: [],
                trainers: [],
            }
        },
        components: {},
        computed: {},
        watch: {
            items() {
            }
        },
        mounted() {
            axios.get("/api/trainers").then((res) => {
                this.data().trainers = res.data;
                console.log(res.data);
            })
        },
        methods: {
        }
    }
</script>

<style scoped>
    .pokeImgsDiv {
        text-align: center;
        position: relative;
        display: block;
        box-sizing: border-box;
        margin-right: auto;
        margin-left: auto;
    }

    .pokeImgDiv {
        display: inline-block;
    }

    .pokeImg {
    }

    .pokeImg:hover {
        color: red;
        cursor: pointer;
        outline: 1px solid gray;
    }

</style>