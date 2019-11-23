<template>
    <div class="registerDiv">
        <h2>TrainerRegister!!</h2>

        <div class="cotainer">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">Register</div>
                        <div class="card-body">
                            <form name="my-form" method="">

                                <div class="form-group row">
                                    <label for="trainer_name"
                                           class="col-md-4 col-form-label text-md-right">トレーナー名</label>
                                    <div class="col-md-6">
                                        <input type="text" id="trainer_name" class="form-control" name="name">
                                    </div>
                                </div>
                                <div class="col-md-6 offset-md-4" style="margin-bottom: 10px">
                                    <button type="button" class="btn btn-primary" v-on:click="register">登録する</button>
                                </div>

                                <div class="col-md-6 offset-md-4">
                                    <button type="button" class="btn btn-danger" v-on:click="returnPreviousPage()">
                                        キャンセル
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>

<script>
    import axios from 'axios'
    import store from '../store/index.js'
    import {mapState} from 'vuex'

    export default {
        name: "TrainerRegisterForm",
        data() {
            return {
                items: [],
                csrf: "",
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
            register() {
                let params = new URLSearchParams();
                params.append('trainerName', document.getElementById("trainer_name").value);
                axios.post("/api/trainers", params).then(() => {
                    this.$router.push("/trainerList")
                });
            },
            returnPreviousPage() {
                this.$router.push(`/trainerList`);
            },
        }
    }
</script>

<style scoped>

    .registerDiv {
        text-align: center;
        position: relative;
        display: block;
        box-sizing: border-box;
        margin-right: auto;
        margin-left: auto;
    }

    form {
        text-align: center;
    }

    .form-group {
        margin-right: auto;
        margin-left: auto;
        width: 500px;
        text-align: center;
    }

    .form-control {
        width: 150%;
    }

    .col-form-label {
        font-size: small;
    }

    body {
        margin: 0;
        font-size: .9rem;
        font-weight: 400;
        line-height: 1.6;
        color: #212529;
        text-align: left;
        background-color: #f5f8fa;
    }

    .my-form .row {
        margin-left: 0;
        margin-right: 0;
    }

    .login-form .row {
        margin-left: 0;
        margin-right: 0;
    }

</style>