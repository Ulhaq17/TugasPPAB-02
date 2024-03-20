// Nama : Mochammad Dhiya Ulhaq
// NIM  : L0122095

data class InfoPegawai(val nama: String, val nik: String, val gaji: Double?)

interface GajiKomisi {
    fun hitungGajiKomisi(): Double
}

open class Pegawai {
    var namaPegawai = "null"
    var nikPegawai = "null"

    open fun hitungGaji() {
        println("Gaji Anda 0")
    }
}

class PegawaiTetap(namaPegawai: String, nikPegawai: String, gajiPokok: Double): Pegawai() {
    private var gajiPokok: Double = 0.0

    init {
        super.namaPegawai = namaPegawai
        super.nikPegawai = nikPegawai
        this.gajiPokok = gajiPokok
    }

    override fun hitungGaji() {
        println("Pegawai atas nama $namaPegawai serta $nikPegawai Gaji Anda $gajiPokok")
    }
}

class PegawaiKomisi(namaPegawai: String, nikPegawai: String, penjualan: Double): Pegawai(), GajiKomisi{
    private var penjualan: Double = 0.0

    init {
        super.namaPegawai = namaPegawai
        super.nikPegawai = nikPegawai
        this.penjualan = penjualan
    }

    override fun hitungGaji() {
        val gajiKomisi = hitungGajiKomisi()
        println("Pegawai atas nama $namaPegawai serta $nikPegawai Gaji Anda $gajiKomisi")
    }

    override fun hitungGajiKomisi(): Double {
        return 0.1 * penjualan
    }
}


fun main() {
    lateinit var inputJenisPegawai: String
    val pegawaiList = mutableListOf<InfoPegawai>()
    val gajiPokok : Double by lazy {
        5000000.0
    }

    println("Aplikasi Penghitung Gaji Pegawai")
    println("--------------------------------")

    do {
        println("1. Pegawai Tetap")
        println("2. Pegawai Komisi")
        println("3. Daftar Pegawai")
        println("4. Keluar")
        print("Masukkan pilihan Anda: ")
        inputJenisPegawai = readlnOrNull().toString()
        val jenisPegawai = inputJenisPegawai.toIntOrNull()

        when (jenisPegawai) {
            1 -> {
                print("Masukkan nama Anda: ")
                val namaPegawai: String = readln()
                print("Masukkan NIK Anda: ")
                val nikPegawai: String = readln()

                val pegawaiTetap = PegawaiTetap(namaPegawai, nikPegawai, gajiPokok)
                pegawaiTetap.hitungGaji()
                pegawaiList.add(InfoPegawai(namaPegawai, nikPegawai, gajiPokok))
            }

            2 -> {
                print("Masukkan nama Anda: ")
                val namaPegawai: String = readln()
                print("Masukkan NIK Anda: ")
                val nikPegawai: String = readln()
                print("Masukkan penjualan Anda: ")
                val inputPenjualan = readlnOrNull()
                val penjualan = inputPenjualan?.toDoubleOrNull()

                val pegawaiKomisi = penjualan?.let { PegawaiKomisi(namaPegawai, nikPegawai, it) }
                val gajiKomisi = 0.1 * penjualan!!
                pegawaiKomisi?.hitungGaji()
                pegawaiList.add(InfoPegawai(namaPegawai, nikPegawai, gajiKomisi))
            }

            3 -> {
                println("\nDaftar Pegawai:")
                pegawaiList.forEach { pegawai ->
                    println("Nama: ${pegawai.nama}, NIK: ${pegawai.nik}, Gaji: ${pegawai.gaji}")
                }
            }
        }
    } while (jenisPegawai == 1 || jenisPegawai == 2 || jenisPegawai == 3)
}