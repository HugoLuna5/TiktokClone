package mx.lunainc.tiktokclone.ui.activities.edit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import mx.lunainc.tiktokclone.R
import mx.lunainc.tiktokclone.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var editProfileViewModel: EditProfileViewModel
    //private lateinit var view: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editProfileViewModel = ViewModelProvider(this)[EditProfileViewModel::class.java]
        //view = ActivityEditProfileBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_edit_profile)

        configViews()
    }

    private fun configViews() {
        title = "Edit profile"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }


        return false
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}