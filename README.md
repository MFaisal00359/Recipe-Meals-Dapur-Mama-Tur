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

a. Arsitektur Aplikasi
Aplikasi Daftar Resep Makanan menggunakan MVVM (Model-View-Viewmodel) yang memisahkan antara logika, tampilan (UI), dan data. Model dalam app ini bertanggung jawab atas representasi data resep makanan, sementara View sebagai antarmuka pengguna yang menampilkan informasi dan menerima masukan. View Model bertindak sebagai perantara antara keduanya, mengelola logika, memproses permintaan dari view, dan berinteraksi dengan Model. Dengan menggunakan arsitektur ini, dapat memudahkan pengembangan aplikasi karena implementasi dari pemisahan dari 3 peran tersebut memudahkan develop dan juga mendesain aplikasi ini.

