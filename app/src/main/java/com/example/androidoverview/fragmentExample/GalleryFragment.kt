package com.example.androidoverview.fragmentExample

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.androidoverview.R
import com.example.androidoverview.utils.Constant
import kotlinx.android.synthetic.main.fragment_gallery.btnCamera
import kotlinx.android.synthetic.main.fragment_gallery.btnGallery
import kotlinx.android.synthetic.main.fragment_gallery.btnOpen
import kotlinx.android.synthetic.main.fragment_gallery.ivCapturedImage
import kotlinx.android.synthetic.main.fragment_gallery.view.btnCamera
import kotlinx.android.synthetic.main.fragment_gallery.view.btnGallery
import kotlinx.android.synthetic.main.fragment_gallery.view.btnOpen

class GalleryFragment: Fragment(), View.OnClickListener {

    lateinit var launcher: ActivityResultLauncher<Intent>
    var isBtnShowing = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        launcher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            ActivityResultCallback { response ->
                if (response.resultCode == AppCompatActivity.RESULT_OK) {
                    ivCapturedImage.setImageBitmap(response.data?.getParcelableExtra(Constant.DATA))
                    ivCapturedImage.setImageURI(response.data?.data)
                } else if (response.resultCode == AppCompatActivity.RESULT_CANCELED) {
                    Toast.makeText(context, R.string.no_image_warning, Toast.LENGTH_SHORT).show()
                }
            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.CAMERA), AppCompatActivity.CONTEXT_INCLUDE_CODE)
        }
        view.btnOpen.setOnClickListener(this)
        view.btnGallery.setOnClickListener(this)
        view.btnCamera.setOnClickListener(this)
        return view
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnOpen -> refreshButtons()
            R.id.btnGallery -> getPicFromGallery()
            R.id.btnCamera -> getPicFromCamera()
        }
    }

    private fun getPicFromCamera() {
        val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
        launcher.launch(cameraIntent)
    }

    private fun getPicFromGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.putExtra(Constant.CAMERA, false)
        launcher.launch(intent)
    }

    private fun refreshButtons() {
        isBtnShowing = !isBtnShowing
        if (isBtnShowing) {
            btnGallery.visible()
            btnCamera.visible()
            btnOpen.setImageResource(R.drawable.ic_round_bookmark_border_24)
        } else {
            btnGallery.gone()
            btnCamera.gone()
            btnOpen.setImageResource(R.drawable.tomato)
        }
    }
}