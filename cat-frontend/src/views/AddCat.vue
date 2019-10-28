<template>
  <div id="addcat">
    <div class="row justify-content-center">
      <div class="col-md-4">
        <h3>Neue Katze zur Datenbank hinzufügen</h3>
      </div>
    </div>
    <div class="row justify-content-center">
      <div class="col-md-4 card">
        <div class="card-body">
          <form @submit="addCat()">
            <div class="form-group">
              <label for="cat-name">Name der Katze</label>
              <input type="text" class="form-control" id="cat-name" v-model="name" />
            </div>
            <div class="form-group">
              <label for="c-picker">Farbe der Katze</label>
              <input type="color" class="form-control" id="c-picker" v-model="color" />
              <span style="font-size: 70px" :style="{color: color}">
                <i class="fa fa-cat"></i>
              </span>
            </div>
            <button type="submit" class="btn btn-secondary">Speichern</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
    data: function () {
      return{
        name: "",
        color: "#000000"
      }
    },

    methods: {
      addCat() {
        axios
        .post('/api/cats', {
          name: this.name,
          color: this.color
        })
        .then(function () {
          alert("Katze wurde erfolgreich angelegt!");
        })
        .catch(e => alert(e));
      }
    }
  }
</script>