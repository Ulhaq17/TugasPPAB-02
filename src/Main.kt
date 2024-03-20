// Nama : Mochammad Dhiya Ulhaq
// NIM  : L0122095

open class Pegawai {
    var namaPegawai = "null"
    var nikPegawai = "null"

    open fun hitungGaji(): Double {
        return 0.0
    }
}

class PegawaiTetap(namaPegawai: String, nikPegawai: String, gajiPokok: Double): Pegawai() {
    private var gajiPokok: Double = 0.0

    init {
        super.namaPegawai = namaPegawai
        super.nikPegawai = nikPegawai
        this.gajiPokok = gajiPokok
    }

    override fun hitungGaji(): Double {
        return gajiPokok
    }
}

class PegawaiKomisi(namaPegawai: String, nikPegawai: String, penjualan: Double): Pegawai(){
    private var penjualan: Double = 0.0

    init {
        super.namaPegawai = namaPegawai
        super.nikPegawai = nikPegawai
        this.penjualan = penjualan
    }

    override fun hitungGaji(): Double {
        return 0.1 * penjualan
    }

}
fun main() {

}
