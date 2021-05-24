package com.example.miujsag.ui.gallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miujsag.R
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


class GalleryFragment : Fragment(), GalleryImageClickListener  {

    // gallery column count
    private val SPAN_COUNT = 2

    private val imageList = ArrayList<Image>()
    private lateinit var imgListRec: RecyclerView
    lateinit var galleryAdapter: GalleryImageAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gallery, container, false)

        galleryAdapter = GalleryImageAdapter(imageList)
        galleryAdapter.listener = this
        imgListRec = view.findViewById(R.id.recyclerView)
        imgListRec.adapter = galleryAdapter
        imgListRec.layoutManager = GridLayoutManager(activity,SPAN_COUNT)
        imgListRec.setHasFixedSize(true)

        loadImages()


        return view
    }

    private fun loadImages() {

        imageList.add(Image("https://scontent.fotp3-1.fna.fbcdn.net/v/t1.6435-9/124916616_3587146341345175_2592197487770507675_n.png?_nc_cat=111&ccb=1-3&_nc_sid=09cbfe&_nc_ohc=94jt6j_Sr1AAX_sbpfO&_nc_ht=scontent.fotp3-1.fna&oh=762703110bbd7de6b0300490cc2847b8&oe=60CFEF88", "Logo"))
        imageList.add(Image("https://scontent.fotp3-3.fna.fbcdn.net/v/t1.6435-9/81556642_2783901118336372_8078534764505595904_n.jpg?_nc_cat=103&ccb=1-3&_nc_sid=e3f864&_nc_ohc=Qewh1pjdSuQAX-7DGua&_nc_ht=scontent.fotp3-3.fna&oh=59657a5b06567f18d259781270dc9f08&oe=60D02057", "Feketen-feheren"))
        imageList.add(Image("https://scontent.fotp3-3.fna.fbcdn.net/v/t31.18172-8/14708016_1238905086169324_8679814781948185374_o.jpg?_nc_cat=108&ccb=1-3&_nc_sid=cdbe9c&_nc_ohc=ItJsEI9b6psAX9EbWVc&_nc_ht=scontent.fotp3-3.fna&oh=a8699c503027be79cffde85c44ca6a0d&oe=60CFD2F9", "Szeretem a bort"))
        imageList.add(Image("https://scontent.fotp3-3.fna.fbcdn.net/v/t31.18172-8/13416898_1127445720648595_2414226677824657172_o.jpg?_nc_cat=101&ccb=1-3&_nc_sid=e3f864&_nc_ohc=R20oF3BwzDEAX-YYZXy&_nc_ht=scontent.fotp3-3.fna&oh=585c22b58f36dddf0b5dbcfb0fadc05c&oe=60D07C58", "Bus team"))
        imageList.add(Image("https://scontent.fotp3-3.fna.fbcdn.net/v/t1.18169-9/21616277_1579056698820826_5920196596814195188_n.jpg?_nc_cat=103&ccb=1-3&_nc_sid=730e14&_nc_ohc=9IYf3FEXjYkAX88X3_x&_nc_ht=scontent.fotp3-3.fna&oh=6c88af82b58ecdca380154ddb4c5ec0a&oe=60CF58E6", "Boti"))
        imageList.add(Image("https://scontent.fotp3-1.fna.fbcdn.net/v/t31.18172-8/22104339_1589307954462367_1217831648349852493_o.jpg?_nc_cat=111&ccb=1-3&_nc_sid=730e14&_nc_ohc=RD0NHeLftLsAX9viWaB&_nc_ht=scontent.fotp3-1.fna&oh=be9d6682bc36a874e171f1d34ef2f839&oe=60D0B57A", "Boro"))
        imageList.add(Image("https://scontent.fotp3-2.fna.fbcdn.net/v/t31.18172-8/22769865_1609597149100114_4551679093408935687_o.jpg?_nc_cat=109&ccb=1-3&_nc_sid=cdbe9c&_nc_ohc=o2QpGcXYw-4AX8RKMGo&_nc_ht=scontent.fotp3-2.fna&oh=38721be1f7425456c468dd17594e7643&oe=60D2760F", "Szeretem a Sapit"))
        imageList.add(Image("https://scontent.fotp3-3.fna.fbcdn.net/v/t31.18172-8/27797980_1719039758155852_5439641267836840575_o.jpg?_nc_cat=108&ccb=1-3&_nc_sid=730e14&_nc_ohc=t4sB28_ZSp8AX_zq3ko&_nc_ht=scontent.fotp3-3.fna&oh=f56d9f58b3e594c30f361cac8489bdb9&oe=60CF5505", "Ujsagok"))
        imageList.add(Image("https://scontent.fotp3-3.fna.fbcdn.net/v/t31.18172-8/15443287_1299385323454633_6879323159162290233_o.jpg?_nc_cat=108&ccb=1-3&_nc_sid=cdbe9c&_nc_ohc=vC1_UqGhS2QAX9leUGF&_nc_ht=scontent.fotp3-3.fna&oh=462e8a0b7927e247b774b769f05dd5c1&oe=60D17AA1", "Zakuszka kostolo"))
        imageList.add(Image("https://scontent.fotp3-1.fna.fbcdn.net/v/t1.18169-9/12347794_1105645409469480_9160971126823797491_n.jpg?_nc_cat=110&ccb=1-3&_nc_sid=825194&_nc_ohc=m_jAfoC7_hcAX-mRwAA&_nc_ht=scontent.fotp3-1.fna&oh=b26a66fa336bfa6cb74239b71c20fd0f&oe=60CF1EF9","Szeretem a szerkesztoket :)"))

        galleryAdapter.notifyDataSetChanged()
    }



    override fun onClick(position: Int) {
        // handle click of image
        val bundle = Bundle()
        bundle.putSerializable("images", imageList)
        bundle.putInt("position", position)
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val galleryFragment = GalleryFullscreenFragment()
        galleryFragment.setArguments(bundle)
        if (fragmentTransaction != null) {
            galleryFragment.show(fragmentTransaction, "gallery")
        }
    }

}