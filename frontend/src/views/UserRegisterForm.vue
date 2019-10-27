<template>
  <div class="registerDiv">
    <h2>UserRegister!!</h2>

    <div class="cotainer">
      <div class="row justify-content-center">
        <div class="col-md-8">
          <div class="card">
            <div class="card-header">Register</div>
            <div class="card-body">
              <form name="my-form" onsubmit="return validform()" action="success.php" method="">

                <div class="form-group row">
                  <label for="user_name" class="col-md-4 col-form-label text-md-right">ユーザーネーム</label>
                  <div class="col-md-6">
                    <input type="text" id="user_name" class="form-control" name="name">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="email_address" class="col-md-4 col-form-label text-md-right">メールアドレス</label>
                  <div class="col-md-6">
                    <input type="text" id="email_address" class="form-control" name="email">
                  </div>
                </div>

                <div class="form-group row">
                  <label for="password" class="col-md-4 col-form-label text-md-right">パスワード</label>
                  <div class="col-md-6">
                    <input type="password" id="password" class="form-control" name="password">
                  </div>
                </div>

<!--                <div class="form-group row">-->
<!--                  <label for="confirm" class="col-md-4 col-form-label text-md-right">パスワード（確認）</label>-->
<!--                  <div class="col-md-6">-->
<!--                    <input type="password" id="confirm" class="form-control" name="confirm"-->
<!--                           v-on:input="checkPassword">-->
<!--                  </div>-->
<!--                </div>-->

                <div class="col-md-6 offset-md-4">
                  <button type="button" class="btn btn-primary" v-on:click="register">登録する</button>
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
    name: "Login",
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
      axios.get("/api/prelogin")
      .then((res) => {
        console.log(res.data);
        this.csrf = res.data;
      })
    },
    methods: {
      register() {
        let params = new URLSearchParams();
        params.append('name', document.getElementById("user_name").value);
        params.append('email', document.getElementById("email_address").value);
        params.append('password', document.getElementById("password").value);
        params.append('_csrf', this.csrf);
        axios.post("/api/user/new", params).then((res) => {
          this.$router.push("/login")
        });
      },
      // checkPassword(confirm){
      //   // 入力値取得
      //   let input1 = document.getElementById('password').value;
      //   let input2 = document.getElementById('confirm').value;
      //   console.log(input1 + "|||" +  input2)
      //   // パスワード比較
      //   if(input1 !== input2){
      //     confirm.setCustomValidity("入力値が一致しません。");
      //   }else{
      //     confirm.setCustomValidity('');
      //   }
      // }
    }
  }
</script>

<style scoped>
    @import url(https://fonts.googleapis.com/css?family=Raleway:300,400,600);

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

  .navbar-laravel {
    box-shadow: 0 2px 4px rgba(0, 0, 0, .04);
  }

  .navbar-brand, .nav-link, .my-form, .login-form {
    font-family: Raleway, sans-serif;
  }

  .my-form {
    padding-top: 1.5rem;
    padding-bottom: 1.5rem;
  }

  .my-form .row {
    margin-left: 0;
    margin-right: 0;
  }

  .login-form {
    padding-top: 1.5rem;
    padding-bottom: 1.5rem;
  }

  .login-form .row {
    margin-left: 0;
    margin-right: 0;
  }

</style>