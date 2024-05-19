# Dapur-Mama-Tur-App
![banner_repo](https://github.com/MFaisal00359/dapur-mama-tur-app/assets/72732958/c74873aa-3a62-4ba1-90ec-331aad8baa54)

Dapur Mama Tur adalah sebuah aplikasi Android yang memudahkan pengguna untuk menemukan resep-resep masakan. Aplikasi ini dikembangkan menggunakan bahasa Kotlin dan memiliki fitur-fitur seperti penyimpanan data menggunakan Room Database dan SQLite.

### Spesifikasi

| Specification          | Value          |
|------------------------|----------------|
| Nama Aplikasi          | Dapur Mama Tur |
| Bahasa Pengembangan    | Kotlin         |
| Target SDK             | 34             |
| Minimum SDK            | 31             |
| Database               | Room Database dan SQLite |
| Lisensi                | Apache 2.0     |

### Instalasi

Clone App:

1. Clone repositori ke lokal Anda:

#### Clone Repo
```bash
git clone https://github.com/nama_pengembang/DapurMamaTur.git
```

#### Pull update repo
```bash
git pull origin main
```

#### Commit update
```bash
git commit
```

#### Push file
```bash
git push origin main
```

### Tentang Aplikasi:
Aplikasi Daftar Resep Makanan (Dapur Mama Tur) adalah aplikasi yang berguna untuk memudahkan pengguna dalam menemukan, menyimpan resep favorit makanan mereka. Aplikasi ini bertujuan untuk memenuhi kebutuhan akses cepat dan praktis terhadap berbagai resep makanan.

### Project Team:
1. Irwan Ferdi Kuswendi  	(121140008)
2. M. Guntur Al Baihaqi  	(121140014)
3. Tiara Putri Elisa  		(121140049)
4. Adriansyah Ramadhan  	(121140051)
5. Muhammad Faisal Safira (121140079)

## System Planning

<ol type='a'>
  <li><b>Arsitekur Aplikasi</b></li>
  <p>Aplikasi Daftar Resep Makanan menggunakan MVVM (Model-View-Viewmodel) yang memisahkan antara logika, tampilan (UI), dan data. Model dalam app ini bertanggung jawab atas representasi data resep makanan, sementara View sebagai antarmuka pengguna yang menampilkan informasi dan menerima masukan. View Model bertindak sebagai perantara antara keduanya, mengelola logika, memproses permintaan dari view, dan berinteraksi dengan Model. Dengan menggunakan arsitektur ini, dapat memudahkan pengembangan aplikasi karena implementasi dari pemisahan dari 3 peran tersebut memudahkan develop dan juga mendesain aplikasi ini. </p><br>

  <li><b>Entity Relationship Diagram (ERD)</b></li>
  <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/84a7bfd3-b44d-4a69-a9e8-80d4fdd4ecbd">
  <p>Dari diagram ER di atas, ada 3 entitas utama yaitu “User”, “Menu’s Recipe”, dan “Recipe Detail”. Di setiap entitas memiliki atribut masing-masing:</p>
  <ul type='disc'>
    <li>“User” memilki atribut “Username”, “Password”, dan “Email” </li>
    <li>“Menu’s Recipe” memiliki atribut “ID Recipe”, “Name Recipe”, “Type”, “API Recipes List”, dan “Favorite” </li>
    <li>“Recipe Detail” memiliki atribut “Ingredients”, “Summarize Food”, “Instruction Food”, “API Recipes Details” </li>
  </ul><br>
  
  <p>Dan untuk Relation dari semua entiti sebagai berikut:	</p>
    <ul type='disc'>
    <li>Access (One-to-Many): Hubungan ini menghubungkan entitas Pengguna ke entitas Menu’s Recipe. Ini menunjukkan bahwa seorang pengguna dapat memiliki akses ke banyak resep. </li>
    <li>Has (One-to-One): Hubungan ini menghubungkan entitas Menu’s Recipe ke entitas API Recipes List. Ini menunjukkan bahwa setiap resep di menu memiliki entri yang sesuai dalam daftar resep API. </li>
    <li>Recipe Detail (One-to-One): Hubungan ini menghubungkan entitas Menu’s Recipe ke entitas Recipe Detail”. Ini menunjukkan bahwa setiap resep di menu memiliki set instruksi yang detail. </li>
  </ul><br>

  <li><b>UML Design</b></li>
  <ul type='disc'>
    <li>Activity Diagram</li>
      <ol type='1'>
        <li><b>Login</b></li>
          <img src="">
        <li><b>Register</b></li>
          <img src="">
        <li><b>Search</b></li>
          <img src="">
        <li><b>Add Recipe to Favorite List</b></li>
          <img src="">
        <li><b>Delete Recipe from Favorite List</b></li>
          <img src="">
        <li><b>Edit profil</b></li>
          <img src="">
      </ol><br>
    <li>Sequence Diagram</li><br>
      <ol type='1'>
      </ol><br>
    <li>Class Diagram</li>
    <img src=""><br>
    <p>Dari class diagram di atas ada 5 class yang terbentuk yaitu User, Menu’s Recipe, Search, Recipe Detail, dan Profile.</p>
    <ol type='1'>
        <li>Class User memiliki atribut username, password, dan email yang memiliki 2 aktivitas yang bisa dilakukan yaitu login dan register.</li>
        <li>Class Menu’s Recipe memiliki atribut namerecipe, type, dan favorite yang memiliki aktivitas search_menu_recipe.</li>
        <li>Class Search memiliki aktivitas search_by_namerecipe untuk mencari nama resep yang diinginkan.</li>
        <li>Class Recipe Detail memiliki atribut summarize fod, ingredients, dan instructionfood yang memiliki aktivitas view_recipe_detail.</li>
        <li>Class Profil memiliki atribut yang sama dengan User namun dengan aktivitas yang berbeda yaitu edit_profile dan log_out.</li>
  </ul><br>
  
</ol>



