<template>
    <div class="trainerListDiv">
        <div class="card-deck" v-for="imgUrl of imgUrls" v-bind:key="imgUrls">
            <div class="card">
                <div class="pokeImgDiv">
                    <img alt="pokemon" class="pokeImg" v-bind:src="imgUrl">
                </div>
                <div class="card-body">
                    <h5 class="card-title">Card title</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to
                        additional content. This content is a little bit longer.</p>
                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                </div>
            </div>
        </div>

        <div class="card text-white bg-danger trainersDiv pleaseCreate" v-if="pokeExist===false">
            <div class="card-header">ポケモンがまだいないようです</div>
            <div class="card-body">
                <p class="card-text">クリックでポケモンを登録しよう！</p>
            </div>
        </div>

    </div>
</template>

<script>
    import axios from 'axios'
    import store from '../store/index.js'
    import {mapState} from 'vuex'

    export default {
        name: "MyPokeListView",
        data() {
            return {
                items: [],
                pokes: [],
                pokeExist: true,
                imgUrls: [],
            }
        },
        components: {},
        computed: {},
        watch: {
            items() {
            }
        },
        mounted() {
            axios.get("/api/pockets").then((res) => {
                this.pokes = res.data;
                console.log(res.data);

                if (this.pokes.length === 0) {
                    this.pokeExist = false;
                } else {
                    for (let i = 0; i <= this.pokes.length; i++) {
                        this.imgUrls.push(`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.pokes[i].pkId}.png`);
                    }
                }
            })
        },
        methods: {}
    }
</script>

<style scoped>
    .trainersDiv {
        width: 300px;
        display: inline-block;
        margin-left: 40px;
        margin-right: 40px;
    }

    .trainersDiv:hover {
        color: red;
        cursor: pointer;
        box-shadow: 0 5px 10px 0 rgba(0, 0, 0, .5);
    }

    .mb-3 {
        margin-bottom: 0 !important;
    }

    .card-header {
        font-size: large;
        font-family: "Hiragino Kaku Gothic Pro";
    }

    .card-title {
        width: 150px;
    }

    .pleaseCreate {
        width: 400px;
    }

    .pokeImg {
        width: 150px;
    }

    .card-deck {
        width: 400px;
        text-align: center;
        margin-left: auto;
        margin-right: auto;
    }

</style>