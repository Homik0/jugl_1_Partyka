/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yourorghere;

import com.sun.opengl.util.texture.Texture;
import javax.media.opengl.GL;

/**
 *
 * @author Homik
 */
public class Scena {

    public float x;
    public float z;
    public float kat;

    public void przesun(float d) {
        x -= d * Math.sin(kat * (3.14f / 180.0f));
        z += d * Math.cos(kat * (3.14f / 180.0f));
    }

    public void Rysuj(GL gl, Texture t3, Texture t4, Texture t5) {
        if (x < 95.0f && x > -95.0f) {
            gl.glRotatef(x, 0.0f, 1.0f, 0.0f);
        } else if (x == -95.0f) {
            x = x + 2.0f;
        } else if (x == 95.0f) {
            x = x - 2.0f;
        }
        if (z < 95.0f && z > -95.0f) {
            gl.glRotatef(z, 0.0f, 1.0f, 0.0f);
        } else if (z == -95.0f) {
            z = z + 2.0f;
        } else if (z == 95.0f) {
            z = z - 2.0f;
        }

        gl.glRotatef(kat, 0.0f, 1.0f, 0.0f);
        gl.glTranslatef(x, 96.0f, 0.0f + z);
//szescian
        gl.glColor3f(1.0f, 1.0f, 1.0f);
//za³adowanie tekstury wczytanej wczeœniej z pliku krajobraz.bmp
        gl.glBindTexture(GL.GL_TEXTURE_2D, t3.getTextureObject());
        gl.glBegin(GL.GL_QUADS);
//œciana przednia
        gl.glNormal3f(0.0f, 0.0f, -1.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-100.0f, 100.0f, 100.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(100.0f, 100.0f, 100.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(100.0f, -100.0f, 100.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-100.0f, -100.0f, 100.0f);
//œciana tylnia
        gl.glNormal3f(0.0f, 0.0f, 1.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-100.0f, -100.0f, -100.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(100.0f, -100.0f, -100.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(100.0f, 100.0f, -100.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-100.0f, 100.0f, -100.0f);
//œciana lewa
        gl.glNormal3f(1.0f, 0.0f, 0.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(-100.0f, 100.0f, -100.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(-100.0f, 100.0f, 100.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-100.0f, -100.0f, 100.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-100.0f, -100.0f, -100.0f);
//œciana prawa
        gl.glNormal3f(-1.0f, 0.0f, 0.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(100.0f, -100.0f, -100.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(100.0f, -100.0f, 100.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(100.0f, 100.0f, 100.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(100.0f, 100.0f, -100.0f);
        gl.glEnd();
//œciana dolna
//za³adowanie tekstury wczytanej wczeœniej z pliku niebo.bmp
        gl.glBindTexture(GL.GL_TEXTURE_2D, t4.getTextureObject());
        //ustawienia aby tekstura siê powiela³a
        gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT);
        gl.glTexParameteri(GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT);
        gl.glBegin(GL.GL_QUADS);
        gl.glNormal3f(0.0f, 1.0f, 0.0f);
        //koordynaty ustawienia 16 x 16 kwadratów powielonej tekstury na œcianie dolnej
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(100.0f, -100.0f, 100.0f);
        gl.glTexCoord2f(0.0f, 16.0f);
        gl.glVertex3f(100.0f, -100.0f, -100.0f);
        gl.glTexCoord2f(16.0f, 16.0f);
        gl.glVertex3f(-100.0f, -100.0f, -100.0f);
        gl.glTexCoord2f(16.0f, 0.0f);
        gl.glVertex3f(-100.0f, -100.0f, 100.0f);
        gl.glEnd();
        //œciana gorna
//za³adowanie tekstury wczytanej wczeœniej z pliku trawa.bmp
        gl.glBindTexture(GL.GL_TEXTURE_2D, t5.getTextureObject());
        gl.glBegin(GL.GL_QUADS);
        gl.glNormal3f(0.0f, -1.0f, 0.0f);
        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(-100.0f, 100.0f, 100.0f);
        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(-100.0f, 100.0f, -100.0f);
        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(100.0f, 100.0f, -100.0f);
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(100.0f, 100.0f, 100.0f);
        gl.glEnd();
    }
}
