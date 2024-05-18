# Dapur-Mama-Tur-App
![banner_repo](https://github.com/MFaisal00359/dapur-mama-tur-app/assets/72732958/c74873aa-3a62-4ba1-90ec-331aad8baa54)

Dapur Mama Tur adalah sebuah aplikasi Android yang memudahkan pengguna untuk menemukan resep-resep masakan dari berbagai daerah. Aplikasi ini dikembangkan menggunakan bahasa Kotlin dan memiliki fitur-fitur seperti penyimpanan data menggunakan Room Database dan SQLite.

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
  
  <li><b>Entity Relationship Diagram (ERD)</b></li><br><br>
  <img src=""><br>
  <p></p><br>
  
  <li><b>UML Design</b></li><br>
  <ul type='disc'>
    <li><i>Activity Diagram</i></li><br>
      <ol type='1'>
        <li><b>Login</b></li><br>
          <img src="">
        <li><b>Register</b></li><br>
          <img src="">
        <li><b>Search</b></li><br>
          <img src="">
        <li><b></b></li><br>
          <img src="">
        <li><b></b></li><br>
          <img src="">
        <li><b>Edit profil</b></li><br>
          <img src="">
        <li><b></b></li><br>
          <img src="">
      </ol><br>
    <li><i>Sequence Diagram</i></li><br>
      <ol type='1'>
      </ol>
  </ul><br>

  <li><b>Class Diagram</b></li><br>
  <img src=""><br>
  <p>     </p>
  <ol type='1'>
    <li></li><br>
    <li><br>
    a. <br>
    b.
    </li><br>
    <li></li><br>
    <li></li><br>
    <li><br>
    </li>
  </ol><br>
  
  <li><b>UI Design (Figma)</b></li><br>
  <ol type='1'>
    <li></li>
    <li></li>
  </ol><br>
</ol>



