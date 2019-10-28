<template>
  <div id="showcats">
    <div class="row justify-content-center">
      <table class="col-md-6 table-striped">
        <thead>
          <th>ID</th>
          <th>Name</th>
          <th>Farbe</th>
        </thead>
        <tbody>
          <tr v-for="cat in cats" v-bind:key="cat.id">
            <td>{{cat.id}}</td>
            <td>{{cat.name}}</td>
            <td>
              <span style="font-size: 30px" :style="{color: cat.color}">
                <i class="fa fa-cat"></i>
              </span>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    data: function () {
      return {
        cats: []
      }
    },
    mounted() {
      axios
        .get('api/cats')
        .then(response => {
          this.cats = response.data;
        })
        .catch(e => alert(e));
    }
  }
</script>