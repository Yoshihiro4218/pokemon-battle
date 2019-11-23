<template>
    <div class="trainerListDiv">
        <div class="card bg-primary text-white text-center p-3 titleDisplay">
            <blockquote class="blockquote mb-0">
                <p style="font-size: 120%"><b>手持ちポケモン</b></p>
            </blockquote>
        </div>
        <div class="card bg-info text-white text-center p-3 titleDisplay allPoke" v-on:click="pushPokeList()">
            <blockquote class="blockquote mb-0">
                <p>全ポケモン一覧</p>
            </blockquote>
        </div>

        <div class="card text-white bg-success mb-3 text-center p-3 titleDisplay ready"
             v-if="battleFlg === true" v-on:click="battleToggle">
            <blockquote class="blockquote mb-0">
                <p>準備完了！</p>
            </blockquote>
        </div>

        <div class="card text-white bg-warning mb-3 text-center p-3 titleDisplay ready"
             v-else v-on:click="battleToggle">
            <blockquote class="blockquote mb-0">
                <p>準備中...</p>
            </blockquote>
        </div>

        <div class="card-deck" v-for="(imgUrl, idx) of imgUrls" :key="idx" style="margin-top: 20px">
            <div class="card">
                <div class="pokeImgDiv">
                    <img alt="pokemon" class="pokeImg" v-bind:src="imgUrl">
                </div>
                <div class="card-body">
                    <h5 class="card-title">{{pokeName[idx]}}</h5>
                    <p class="card-text">This is a longer card with supporting text below as a natural lead-in to
                        additional content. This content is a little bit longer.</p>
                    <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
                </div>
            </div>
        </div>

        <div class="card text-white bg-danger trainersDiv pleaseCreate"
             v-if="pokeExist===false" v-on:click="pushPokeList()">
            <div class="card-header">ポケモンがまだいないようです</div>
            <div class="card-body">
                <p class="card-text">クリックでポケモンを登録しよう！</p>
            </div>
        </div>

    </div>
</template>

<script>
    import axios from 'axios'
    import json from '../assets/js/pokemon_translate';
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
                pokeName: [],
                battleFlg: false,
            }
        },
        components: {},
        computed: {},
        watch: {
            items() {
            }
        },
        mounted() {
            let trainerId = this.$route.query["id"];
            axios.get(`/api/pockets/${trainerId}`).then((res) => {
                this.pokes = res.data;
                console.log(res.data);

                if (this.pokes.length === 0) {
                    this.pokeExist = false;
                } else {
                    for (let i = 0; i < this.pokes.length; i++) {
                        console.log('-------pokeId---------');
                        console.log(this.pokes[i].pkId);
                        this.imgUrls.push(`https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${this.pokes[i].pkId}.png`);
                    }
                    // for (let i = 0; i < this.pokes.length; i++) {
                    //     axios.get(`https://pokeapi.co/api/v2/pokemon/${this.pokes[i].pkId}`)
                    //         .then((res2) => {
                    //             let nameEn = res2.data.forms[0].name;
                    //             console.log(nameEn)
                    //
                    //
                    //             for (let j = 0; j < json.length; j++) {
                    //                 if (json[j].en.toLowerCase() === nameEn) {
                    //                     let nameJa = json[j].ja;
                    //                     console.log(nameJa);
                    //                     this.pokeName.push(nameJa);
                    //                 }
                    //             }
                    //
                    //             // this.pokeName.push(JSON.parse(json).filter(p => p.en.toLowerCase() === nameEn));
                    //         })
                    // }

                }
                axios.get(`/api/trainers/battleToggle/${trainerId}`)
                    .then((res) => {
                        this.battleFlg = res.data;
                    })
            })
        },
        methods: {
            pushPokeList() {
                let trainerId = this.$route.query["id"];
                this.$router.push(`/pokeList?id=${trainerId}`);
            },
            battleToggle() {
                let trainerId = this.$route.query["id"];
                axios.get(`/api/trainers/battleToggle/${trainerId}`)
                    .then((res) => {
                        this.battleFlg = res.data;
                        if (res.data) {
                            window.alert('自動的にランダムで対戦が行われます')
                        } else {
                            window.alert('準備中は対戦は行われません')
                        }
                    })
            }
        }
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

    .ready:hover {
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

    .titleDisplay {
        margin-bottom: 30px;
        height: 60px;
        width: 368px;
        text-align: center;
        position: relative;
        display: block;
        margin-right: auto;
        margin-left: auto;
    }

    .allPoke:hover {
        cursor: pointer;
        box-shadow: 0 5px 10px 0 rgba(0, 0, 0, .5);
    }

</style>