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
  
  <p>Kemudian untuk Relation dari semua entiti sebagai berikut:	</p>
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
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/bde361a9-bd63-41df-bcb2-8d0a485e8fe1">
        <li><b>Register</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/8d41a4a6-4e96-4eb7-8938-9f88e078d07e">
        <li><b>Search</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/61180281-ced4-42c3-b9fe-2c4f9b773c53">
        <li><b>Add Recipe to Favorite List</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/ee53a3da-2d67-4ad6-add2-f00cc7285adf">
        <li><b>Delete Recipe from Favorite List</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/6694d222-53f8-4929-87a3-559c0d40bf9a">
        <li><b>Edit Profil</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/7ec9586e-022e-4f5d-9015-c10a657eaf67">
        <li><b>Logout</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/9da55f58-ffcc-492b-a0cd-ffa1cc78f662">
      </ol><br>
    <li>Sequence Diagram</li><br>
      <ol type='1'>
        <li><b>Login Sequence</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/47b1b626-dbac-4731-9c83-edc20017b16d)">
        <li><b>Register Sequence</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/75a90ee7-0887-40fd-9e95-551c6c27149e">
        <li><b>Search Sequence</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/64fb28dc-0777-4541-a12d-cc37bf4cf165">
        <li><b>Add Recipe to Favorite List Sequence</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/2349ebe3-f766-4f38-99a7-1d46c5235354">
        <li><b>Delete Recipe from Favorite List Sequence</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/253c993d-b08c-42ee-bff4-d320dba92c1a">
        <li><b>Edit Profil Sequence</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/8d3f3fd9-e4e1-465b-ab73-18e9ce16f9a9">
        <li><b>Logout Sequence</b></li>
          <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/8be79124-d4bd-4c4c-9e87-ff637314d055">
      </ol><br>
    <li>Class Diagram</li>
    <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/b1fc3679-911c-4765-a46a-dc90c152eb03"><br>
    <p>Dari class diagram di atas ada 5 class yang terbentuk yaitu User, Menu’s Recipe, Search, Recipe Detail, dan Profile.</p>
    <ol type='1'>
        <li>Class User memiliki atribut username, password, dan email yang memiliki 2 aktivitas yang bisa dilakukan yaitu login dan register.</li>
        <li>Class Menu’s Recipe memiliki atribut namerecipe, type, dan favorite yang memiliki aktivitas search_menu_recipe.</li>
        <li>Class Search memiliki aktivitas search_by_namerecipe untuk mencari nama resep yang diinginkan.</li>
        <li>Class Recipe Detail memiliki atribut summarize fod, ingredients, dan instructionfood yang memiliki aktivitas view_recipe_detail.</li>
        <li>Class Profil memiliki atribut yang sama dengan User namun dengan aktivitas yang berbeda yaitu edit_profile dan log_out.</li>
  </ul><br>
</ol>

## Application Development Stage

<ol type='a'>
  <li><b>Tahap Implementasi</b></li>
  <p>Extreme Programming (XP) merupakan pilihan yang tepat untuk pengembangan aplikasi seperti "Aplikasi Daftar Resep Makanan" karena fokusnya pada respons cepat terhadap perubahan kebutuhan pelanggan dan pengiriman perangkat lunak yang berkualitas tinggi dalam waktu yang singkat. Berikut adalah alasan mengapa XP cocok digunakan dalam pengembangan aplikasi ini yang menggunakan arsitektur MVVM (Model-View-ViewModel): </p><br>
  <ul type='disc'>
    <li>Iterasi Cepat: Dalam XP, pengembangan dilakukan secara iteratif dan inkremental. Ini memungkinkan tim untuk menghasilkan versi awal aplikasi dengan fitur-fitur dasar yang bisa segera digunakan oleh pengguna, seperti menambahkan, mencari, dan mengelola resep makanan. Setiap iterasi memberikan kesempatan untuk menguji dan memperbaiki aplikasi, serta menyesuaikan fitur sesuai dengan umpan balik pelanggan. </li>
    <li>Pair Programming: Praktik pair programming dalam XP memungkinkan programmer untuk bekerja bersama secara langsung, dengan satu orang menulis kode sementara yang lainnya memberikan masukan dan melakukan pengujian. Dalam konteks aplikasi ini, pair programming dapat membantu memastikan bahwa logika bisnis terkait manajemen resep makanan terimplementasikan dengan baik dan efisien. </li>
    <li>Pengujian Otomatis: XP mendorong penggunaan pengujian otomatis yang kuat. Dalam pengembangan aplikasi daftar resep makanan, ini dapat mencakup pengujian unit untuk memastikan fungsi-fungsi seperti menambahkan, mengedit, dan menghapus resep berfungsi dengan benar, serta pengujian integrasi untuk memastikan seluruh sistem berinteraksi dengan baik. </li>
    <li>Refaktorisasi Reguler: XP mendorong praktik refaktorisasi kode secara teratur. Dengan menggunakan arsitektur MVVM, tim pengembang dapat dengan mudah mengidentifikasi bagian-bagian kode yang perlu ditingkatkan atau diperbaiki, serta memisahkan logika bisnis dari tampilan. Ini membantu menjaga kebersihan dan keterbacaan kode, serta memudahkan pengembangan dan pemeliharaan aplikasi di masa mendatang.
</li>
  </ul><br>
  <p>Dengan kombinasi XP dan arsitektur MVVM, pengembang dapat menciptakan aplikasi daftar resep makanan yang kelincahan, mudah diubah, dan berkualitas tinggi, sambil tetap memenuhi kebutuhan dan ekspektasi pengguna.</p>

  <li><b>Time Plan</b></li>
  <p>Estimasi waktu pengerjaan proyek aplikasi</p>
  <img src="https://github.com/MFaisal00359/dapur-mama-tur-app/assets/148713333/e57a0772-e05c-4416-a067-76c2e9b14989">
</ol>

## Download Aplikasi
https://drive.google.com/file/d/195ESnuz2vhWellh-4oytGETK5EQIYuD5/view?usp=drive_link

## Figma
https://www.figma.com/file/TRjE8ffNrQ6I9CBc7O6POE/PAM-UAS?type=design&node-id=0%3A1&mode=design&t=yy3gRLAKJwr80Swm-1

