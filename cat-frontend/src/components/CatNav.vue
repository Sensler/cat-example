<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample08" aria-controls="navbarsExample08" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse justify-content-md-center" id="navbarsExample08">
      <ul class="navbar-nav">
        <li class="nav-item active">
          <router-link to="/show-cats" class="nav-link">Show Cats</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/add-cat" class="nav-link">Add Cat</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>