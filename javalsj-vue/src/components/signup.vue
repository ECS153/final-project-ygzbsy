<template><div class = "signup-form" :class = "sin_dis">
<el-form :model="dynamicValidateForm" ref="dynamicValidateForm" label-width="150px" class="demo-dynamic">
  <el-form-item prop="email" label="Email"
    :rules="[
      { required: true, message: 'Please enter email address', trigger: 'blur' },
      { type: 'email', message: 'Please enter a valid email address', trigger: ['blur', 'change'] }
    ]"
  >
    <el-input v-model="dynamicValidateForm.email"></el-input>
  </el-form-item>

  <el-form-item label="Password" prop="pass" :rules="[{required: true}]">
    <el-input type="password" v-model="dynamicValidateForm.pass" autocomplete="off"></el-input>
  </el-form-item>
  <el-form-item label="Password Confirm" prop="checkPass" :rules="[{required: true}]">
    <el-input type="password" v-model="dynamicValidateForm.checkPass" autocomplete="off"></el-input>
  </el-form-item>

  <el-form-item>
    <el-button id = "signup-button"type="primary" @click="submitForm('dynamicValidateForm')">Confirm</el-button>
  </el-form-item>
</el-form>
</div>
</template>
<script>
  export default {
    data() {
      return {
        sin_dis: '',
        dynamicValidateForm: {
          email: ''
        }
        //
      };
    },
    methods: {
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        });
      }
    }
  }
</script>

<style>
.signup-form{
  visibility:hidden;
  width:100%;
  padding-top:10%;
  clear:right;
  display: flex;
  justify-content: center;
  align-items: center;
  position: absolute;
  z-index: 1;
}
.active{
  visibility: visible;
}
#signup-button{
  margin-left:30%;
}
</style>
