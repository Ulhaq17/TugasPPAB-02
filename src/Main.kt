// Nama : Mochammad Dhiya Ulhaq
// NIM  : L0122095

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

class PegawaiKomisi(namaPegawai: String, nikPegawai: String, penjualan: Double): Pegawai(){
    private var penjualan: Double = 0.0

    init {
        super.namaPegawai = namaPegawai
        super.nikPegawai = nikPegawai
        this.penjualan = penjualan
    }

    override fun hitungGaji() {
        val gajiKomisi = 0.1 * penjualan
        println("Pegawai atas nama $namaPegawai serta $nikPegawai Gaji Anda $gajiKomisi")
    }

}
fun main() {
    val gajiPokok = 5000000.0

    println("Aplikasi Penghitung Gaji Pegawai")
    println("--------------------------------")
    print("Masukkan nama Anda: ")
    val namaPegawai: String = readln()
    print("Masukkan NIK Anda: ")
    val nikPegawai: String = readln()
    print("Masukkan penjualan Anda: ")
    val inputpenjualan: String = readln()
    val penjualan = inputpenjualan.toDoubleOrNull()

    val pegawaiTetap = PegawaiTetap(namaPegawai, nikPegawai, gajiPokok)
    val pegawaiKomisi = penjualan?.let { PegawaiKomisi(namaPegawai, nikPegawai, it) }
    pegawaiTetap.hitungGaji()
    pegawaiKomisi?.hitungGaji()

}
