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
    <li><i>Model</i>: Bagian ini bertanggung jawab atas logika bisnis dan data aplikasi. Model mewakili sumber daya data        seperti tempat-tempat makan dan menyediakan operasi untuk mengambil, menyimpan, dan memperbarui data. Ini juga dapat        mencakup integrasi dengan layanan pihak ketiga, seperti Google Places API, untuk mengambil informasi tempat makan. </li>
    <br>
    <li><i>View</i>: Bagian ini adalah antarmuka pengguna (UI) yang dilihat dan digunakan oleh pengguna. View hanya             menampilkan informasi dan mengirim perintah ke ViewModel. Dalam konteks aplikasi ini, View akan menampilkan daftar          tempat makan, detail tempat makan, kolom pencarian, dan lainnya. </li>
    <br>
    <li><i>ViewModel</i>: Bagian ini bertindak sebagai perantara antara Model dan View. ViewModel bertanggung jawab untuk       mempersiapkan dan menyajikan data dari Model ke View, serta menangani interaksi pengguna dan logika tampilan. Misalnya,     ViewModel akan mengambil daftar tempat makan dari Model dan menyiapkannya untuk ditampilkan di View. Ini juga akan          merespons perubahan yang dilakukan pengguna di antarmuka pengguna, seperti ketika pengguna memasukkan kriteria              pencarian, dan memperbarui Model sesuai dengan itu. </li>
  </ul><br>
  
  <p>Dengan menggunakan arsitektur MVVM, Eatera memisahkan peran antara logika aplikasi dan tampilan pengguna, sehingga       memudahkan pengembangan tim yang terdiri dari desainer dan pengembang. Tim desainer dapat fokus pada desain antarmuka       pengguna tanpa perlu memperhatikan logika aplikasi, sementara tim pengembang dapat berkonsentrasi pada implementasi         logika aplikasi tanpa harus terganggu oleh tampilan pengguna. Hal ini meningkatkan efisiensi pengembangan aplikasi dan      memungkinkan kolaborasi yang lebih baik antara anggota tim.	</p><br
  
  <li><b>Entity Relationship Diagram (ERD)</b></li><br><br>
  <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/main/Image/ERD_PAM.png"
    width = "750"
    height = "350"><br>
  <p>Dari diagram ER di atas, ada empat entitas utama yaitu "Tempat Makan", "Daftar Favorit", "User", dan "Detail Tempat      Makan". Setiap entitas memiliki atributnya sendiri. "user" dalam hubungannya dengan "Tempat Makan" dan "Daftar Favorit"     adalah "Akses", sementara "Tempat Makan" dan “Daftar Favorit” dalam hubungannya dengan "Detail Tempat Makan" adalah         "Memiliki".</p><br>
  
  <li><b>UML Design</b></li><br>
  <ul type='disc'>
    <li><i>Activity Diagram</i></li><br>
      <ol type='1'>
        <li><b>Login</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Activity_Diagram_Login.png">
        <li><b>Register</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Activity_Diagram_Register.png">
        <li><b>Search</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Activity_Diagram_Search.png">
        <li><b>Menambahkan Tempat Makan Favorit</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Activity_Diagram_Add_Favorite.png">
        <li><b>Menghapus Tempat Makan Favorit</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Activity_Diagram_Delete_Favorite.png">
        <li><b>Edit profil</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Activity_Diagram_Edit_Profil.png">
        <li><b>Logout</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Activity_Diagram_Logout.png">
      </ol><br>
    <li><i>Sequence Diagram</i></li><br>
      <ol type='1'>
        <li><b>Login Sequence</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Login.png">
        <li><b>Register Sequence</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Register.png">
        <li><b>Search Sequence</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Search.png">
        <li><b>Add Favorite Sequence</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Add_Favorite.png">
        <li><b>Delete Favorite Sequence</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Delete_Favorite.png">
        <li><b>Edit Profile Sequence</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Edit_Profile.png">
        <li><b>Logout Sequence</b></li><br>
          <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Logout.png">
      </ol>
  </ul><br>

  <li><b>Class Diagram</b></li><br>
  <img src="https://github.com/121140084-Rizki-Esa-Fadillah/Tugas_Besar_PAM/blob/master/Image/Class_Diagram_PAM.png"
    width = "750"
    height = "750"><br>
  <p>
    Dalam Class Diagram ini terdapat 6 kelas, antara lain : User, Tempat Makan, Search, Profil, List, dan Favorite List.      </p>
  <ol type='1'>
    <li>Kelas User memiliki lima atribut antara lain atribut Nama, Jenis Kelamin, Usia, Email dan Password. Dengan              menggunakan atribut-atribut ini, kita dapat menjalankan 2 metode, yaitu login atau register.</li><br>
    <li>Kelas Tempat Makan memiliki atribut-atribut yang digunakan untuk menjelaskan detail informasi seputar tempat makan      yang sedang dilihat, mulai dari Nama, Jarak, Rating, Jenis Masakan, Alamat, Jam Operasional, Menu Makanan, dan Ulasan.      Dengan atribut-atribut tersebut, akan ada 2 metode yang dapat dijalankan: <br>
    a. Search_tempat_makan: untuk mencari tempat makan sesuai preferensi user.<br>
    b. Add_to_favorite: untuk menambahkan tempat makan tersebut ke daftar favorit user. 
    </li><br>
    <li>Kelas Search akan digunakan untuk menjalankan 4 fungsi antara lain: search_by_nama (berdasarkan nama tempat makan),     search_by_jenis_masakan (berdasarkan jenis masakan), search_by_rating (berdasarkan rating pelanggan), dan                   search_by_jarak (berdasarkan jarak antara pengguna dengan tempat makanan). Fungsi - fungsi ini dapat digunakan untuk        mencari tempat makan yang sesuai dengan preferensi user dengan menggunakan kolom pencarian pada aplikasi. </li><br>
    <li>Kelas List akan berisi semua tempat makan yang telah ditambahkan oleh user ke daftar favorite. Kelas ini akan           berisi beberapa atribut tentang tempat makan yang telah ditambahkan ke dalam daftar favorit, seperti nama,jenis             masakan, jarak dan rating. Dan user dapat menggunakan atribut ini untuk mencari tempat makan tersebut di dalam daftar       (search_list) atau untuk menghapusnya dari daftar (delete_from_list). Kelas ini juga memiliki kelas turunan yaitu           Favorite List. </li><br>
    <li>Kelas Profile akan terdiri dari beberapa atribut tentang pengguna, seperti Nama, Jenis Kelamin, Usia, Email dan         Password. Dalam kelas ini pengguna dapat menjalankan beberapa metode seperti: <br>
    a. Edit_profile: untuk mengubah data profil user.<br>
    b. See_favorite_list: untuk masuk ke halaman daftar favorit.<br>
    c. Logout: untuk keluar dari akun kita.
    </li>
  </ol><br>
  
  <li><b>UI Design (Figma)</b></li><br>
  <ol type='1'>
    <li></li>
    <li></li>
  </ol><br>
</ol>



