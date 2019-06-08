data segment
    noire db 0dh," case noire ",0dh,0ah,24h
    retour db 0dh," pas de retour en arriere ",0dh,0ah,24h
    pkey db 0dh," merci et a bien tot ...",0dh,0ah,24h 
    plein db 0dh," case non vide ",0dh,0ah,24h
    interdit db 0dh," saut interdit ",0dh,0ah,24h  
    possibled db 0dh," deplassement possible_directe ",0dh,0ah,24h 
    possiblei db 0dh," deplassement possible_indirecte ",0dh,0ah,24h 
    blanche db 0dh," case blanche ",0dh,0ah,24h 
    depassement db 0dh," erreur de saisie retaper les indices ",0dh,0ah,24h
    chariot db 0dh,0ah,24h 
    ligne db 0dh,24h
    rien db 0dh," aucun deplacement ",0dh,0ah,24h 
    victoire db 0dh," bravo vous avez gagné ",0dh,0ah,24h  
    menu db 0dh," a:afficher la matrice ",0dh,0ah,"b:ouvrire une case ",0dh,0ah,"c:initialisation ",0dh,0ah,"d:couleur de la case ",0dh,0ah,"e:numero d'une case ",0dh,0ah,"f:indices d'une case ",0dh,0ah,"g:exit h:afficher le menu ",0dh,0ah,24h
    tab db 51 dup (0)
ends
stack segment
    dw   128  dup(0)
ends
code segment
start:
    mov ax, data
    mov ds, ax
    mov es, ax     
    
    lea dx,menu
    mov ah, 9
    int 21h     
             
    call initialisation
refaire:  
    call manu
    cmp al,0
    jz fin 
    
    ho:   
    call lecture_indices_case 
    cmp al,0
    jz ho
    mov dx,bx  
    
    hi:
    call lecture_indices_case
    cmp al,0
    jz hi 
    mov cx,bx
    
    call fonction 
    
    call aghiles
    cmp al,0
    jz fin 

       
    jmp refaire
    
    fin:         
    lea dx, pkey
    mov ah, 9
    int 21h       
           
    mov ah, 1
    int 21h
    
    mov ax, 4c00h 
    int 21h 
       

manu proc 
  t2:
        
    mov ah, 1
    int 21h
        
    cmp al,68h
    jnz t9
    lea dx,menu
    mov ah, 9
    int 21h
    jmp t2
    t9:
    
    cmp al,61h
    jnz t1
    call affichage
    jmp t2
    t1:
    
    cmp al,62h
    jnz t3
    call lecture_numero_case
    call contenu_case
    jmp t2
    t3:
    
    cmp al,63h
    jnz t4
    call initialisation
    jmp t2
    t4:
    
    cmp al,64h
    jnz t5
    call lecture_indices_case
    call blanche_noire
    jmp t2
    t5:
    
    cmp al,65h
    jnz t6
    call lecture_indices_case
    call numero_case
    call afficher_numero_case
    jmp t2
    t6:
    
    cmp al,66h
    jnz t7
    call lecture_numero_case
    call indices_case
    call afficher_indices_case
    jmp t2
    t7:
    
    cmp al,67h
    jnz t8
    mov al,0
    t8:
    ret
 endp   
       
aghiles proc
    mov cx,50                         ;verifier si le 1er jouer a gagné
    mov si,1 
    boucle8:
    cmp byte ptr tab[si],1
    jz n1  
    cmp byte ptr tab[si],2
    jz n1
    inc si    
    loop boucle8
    lea dx, victoire
    mov ah, 9
    int 21h
    mov al,0 
    ret
    n1: 
                                       ;verifier si le 2eme joueur a gagné
    mov cx,50
    mov si,50 
    boucle9:
    cmp byte ptr tab[si],3
    jz n2
    cmp byte ptr tab[si],4
    jz n2
    dec si    
    loop boucle9
    lea dx, victoire
    mov ah, 9
    int 21h 
    mov al,0
    ret
    n2:    
    mov al,1
    ret
endp           
 
verifier proc
    cmp byte ptr tab[si],0  ;si la case de depart est vide il n'y a aucun deplassement
    jnz x1
    lea dx,rien
    mov ah, 9
    int 21h 
    ret 
    x1:
    cmp byte ptr tab[si],1  ;le 1er joueur ne peut pas reculer
    jnz x2 
    cmp cl,dl
    ja x3
    lea dx,retour
    mov ah, 9
    int 21h 
    ret
    x2:
    cmp byte ptr tab[si],3  ;le 2eme joueur ne peut pas reculer
    jnz x3  
    cmp dl,cl
    ja x3
    lea dx,retour
    mov ah, 9
    int 21h 
    ret
    x3: 
    cmp byte ptr tab[di],0  ;si la case d'arrivé est pleine alors dépplassement non autorisé
    jz x4
    lea dx,plein
    mov ah, 9
    int 21h 
    ret
    x4:
    mov al,0                ;sinon retourner 0 
    ret
endp

fonction proc            
    mov bx,cx              ;optenir le numero de la case de d'epart a partir de ses indices
    call numero_case   
    mov di,bx 
    
    mov bx,dx              ;optenir le numero de la case d'arriver a partir de ses indices
    call numero_case   
    mov si,bx
          
    call verifier          ;verifier les erreur de deplassement
    cmp al,0  
    jnz finish 
         
    call directe           ;faire un deplassement direct si c'est possible 
    cmp al,0
    jz finish 
                          
    call indirecte         ;faire un deplassement indirect si c'est possible 
     
    finish:
    ret
endp 
    
affichage proc
    mov si,1               ;faire un retour a la ligne
    lea dx,ligne
    mov ah, 9
    int 21h
 boucle:
    xor bl,bl  
 s1:                      
    mov dl,0              ;afficher une case blanche
    mov ah,2
    int 21h
    
    mov dl,byte ptr tab[si]     ;afficher le contenu de la case noir
    add dl,30h
    mov ah,2
    int 21h   
    inc si
    inc bl
    cmp bl,5
    jnz s1
    
    lea dx,chariot           ;faire un retour a la ligne
    mov ah, 9
    int 21h
 s2:    
    mov dl,byte ptr tab[si]    ;afficher le contenu de la case noir
    add dl,30h
    mov ah,2
    int 21h   
    inc si 
    
    mov dl,0             ;afficher une case blanche
    mov ah,2
    int 21h  
    inc bl
    cmp bl,10
    jnz s2
    
    lea dx,chariot         ;faire un retour a la ligne
    mov ah, 9
    int 21h
    
    cmp si,50
    jb boucle
    ret
endp

contenu_case proc              
    xor bh,bh                  ;afficher le contenu d'une case a partir de son numero
    mov si,bx
    mov bl,byte ptr tab[si]
    xor bh,bh
    call afficher_numero_case
    ret
endp

initialisation proc      
    mov cx,20                     ;remplir les 20 premier cases avec des 1
    mov si,1
 boucle1:
    mov byte ptr tab[si],1 
    inc si
    loop boucle1
    
    mov cx,20                     ;remplir les 20 premier cases avec des 3
    mov si,31
 boucle2:
    mov byte ptr tab[si],3
    inc si
    loop boucle2
    ret
endp


blanche_noire proc   
    mov al,bl                                    ;on divise le 1er indice sur 2 pour connaitre sa parité  
    mov bl,2
    xor ah,ah 
    div bl 
    mov al,bh
    mov bh,ah 
    
    xor ah,ah                   ;on divise le 2eme indice sur 2 pour connaitre sa parité
    div bl    
    
    cmp ah,bh                   ;si les deux indices d'une case en la meme parité alors c'est une case blanche
    jnz r1
    lea dx, blanche
    mov ah, 9
    int 21h
    ret
    r1:
    lea dx, noire              ;sinon noire
    mov ah, 9
    int 21h    
    ret
    e31:  
    ret
endp


numero_case proc   
    push ax                      ;sauvegarde du grand contexte
    mov ax,bx                    ;numero de la case =al*5-(10-ah)/2
    mov bl,ah
    mov bh,5
    xor ah,ah
    mul bh 
    mov ah,bl                
    mov bl,al
    mov al,10
    sub al,ah 
    xor ah,ah
    mov bh,2
    div bh
    sub bl,al                 ;on met me numero de la case dans bl
    xor bh,bh
    pop ax                    ;restauration du grand contexte
    ret
endp 

indices_case proc  
    mov al,bl
    mov bh,al               
    cmp al,50
    jbe a1                         ;verifier si la saisie est correcte
    lea dx, depassement
    mov ah, 9
    int 21h
    ret
    a1:  
    xor ah,ah                      ;on divise le numero de la case sur 10
    mov bl,10                      
    div bl                         
    cmp ah,0                       
    jz e1 
    cmp ah,5
    jbe e2
    add ah,ah
    sub ah,11                     ;si le reste R>5  alors  i=R*2-11
    jmp d1
    e2:
    add ah,ah                     ;            R<=5 alors  i=R*2
    jmp d1 
    e1:
    mov ah,9                      ;            R=0  alors  i=9;
    d1:
    mov al,bh
    mov bh,ah
         
    xor ah,ah                     ;on divise le numero de la case sur 5
    mov bl,5                      ;si R=0 alors j=R
    div bl
    cmp ah,0
    jz e4
    add  al,1                     ;sinon j=R+1
    e4: 
    mov bl,al 
    
    ret
endp  
     
lecture_numero_case proc
    xor bx,bx                    ;on initialise bx a 0
    mov cl,10 
    xor dh,dh                    ;dx joura le role d'une file pour prevoir la fin de la lecture
    
    mov ah,1                     ;lecture d'un caractere
    int 21h  
    cmp al,24h                   ;si c'est un $ fin de lecture
    jz e12kk
    mov dl,al                    ;on met notre caractere dans  dl 
bouclekk:      
    mov ah,1                     ;on lit un autre caractere et on le met dans ch
    int 21h  
    mov ch,al
     
    sub dl,61h 
   
    add bx,dx                    ;on additionne le 1er caractere lut avec le contenu de bx
    
    cmp ch,24h
    jz e12kk                     ;si le 2eme caractere lut est un $ fin de lecture
    
    mov ax,bx
    mul cl                        ;on multiplie bx par 10
    mov bx,ax
    mov dl,ch                     ;et on recupere le caractere suivant dans dl
             
    jmp bouclekk
    e12kk: 
    ret
 endp     
     
afficher_numero_case proc       
    mov ax,bx 
    mov dl,10                ;on met le contenu de bx dans ax
    xor di,di
 decimale:
    div dl                   ;on divise ax par 10 et met le reste dans la pile
    push ax
    inc di
    cmp al,0                 ;si le reste est 0 on passe a l'affichage
    jz afficher
    xor ah,ah
    jmp decimale
    
 afficher:
    pop dx                   ;on disempile dx 
    mov dl,dh
    add dl,30h
    mov ah,02                ;et on affiche les restes de la la division precedente
    int 21h  
    dec di
    jnz afficher 
    
    mov dl,64h               ;pour indiquer que la valeur est en decimale
    mov ah,2
    int 21h
    
    ret
endp 

afficher_indices_case proc
    mov cx,2       
 hexa:
    rol bx,8                      ;on inverce les deux mot du registre 
    mov dx,bx
    and dx,00ffh                  ;on recupère le mot du poid faible
    cmp dl,9
    jbe chiffre                   
    add dl,7h                     ;si c'est un alphabet on lui ajoute 7h et on lui substrait 30h plus 
    chiffre:                      
    add dl,30h                   ;si c'est un chiffre on lui substrait 30h 
    mov ah,2                     
    int 21h                      ;et on affiche le resultat
    loop hexa
      
    mov ah,2
    mov dl,68h
    int 21h
      
    ret
endp

lecture_indices_case proc 
           
    xor bx,bx
    mov cx,2
 hexac:
    rol bx,8
    mov ah,1                            ;on lit  un caractere
    int 21h  
    xor ah,ah 
    cmp al,41h                          ;on verifier si il appartient a[1,10]
    jb sortirr                          ;si c'est pas le cas on affiche un message d'erreure
    cmp al,61h
    ja sortirr       
    cmp al,4ah
    jbe chiffrec  
    cmp al,61h
    jb sortirr
    sub al,16h
 chiffrec:     
    sub al,41h  
    or bx,ax 
    loop hexac 
    
    mov cx,bx                           ;on verifier si les indices saisies corespond a une case noire
    mov al,bl 
    mov cl,2
    xor ah,ah 
    div cl 
    mov al,bh
    mov ch,ah 
    
    xor ah,ah
    div cl
    cmp ah,ch
    jnz cbon                            ;si c'est pas le cas on affiche un message d'erreure 
    sortirr: 
    lea dx,depassement
    mov ah, 9
    int 21h 
    mov al,0 
    ret
    cbon: 
    mov al,1
    ret
endp 

directe_long proc    
    mov ax,dx

c22: 
    cmp dh,ch                ;on compare les indices de ligne de chaque case 
    jb a15h
    dec ah
    jmp a19h
    a15h:
    inc ah
    a19h:
    
    cmp dl,cl
    jb a15ht
    dec al
    jmp a19ht
    a15ht:
    inc al
    a19ht:
        
    mov bx,ax
    call numero_case 
    cmp byte ptr tab[bx],0 
    jz c11
    lea dx,plein
    mov ah, 9
    int 21h
    ret
    c11:
    cmp ax,cx
    jz possible_directeyo
    jmp c22
    
    possible_directeyo:
    
    mov al,byte ptr tab[si]
    mov byte ptr tab[si],0
    mov byte ptr tab[bx],al 
                       
    lea dx, possibled
    mov ah, 9
    int 21h   
    mov al,0 
    ret      
 
endp
 
directe proc    
    mov ax,dx
 
    cmp byte ptr tab[si],1
    jnz i1
    inc al
    jmp i3
    i1:
    cmp byte ptr tab[si],3
    jnz i2
    dec al
    jmp i3
    i2: 
    call directe_long
    ret
    i3: 
        
    cmp dh,ch
    jb a15htj
    dec ah
    jmp a19htj
    a15htj:
    inc ah
    a19htj:  
 
    mov bx,ax
    call numero_case 
    cmp byte ptr tab[bx],0 
    jz c1
    jmp c2
    c1:
    cmp ax,cx
    jz possible_directey
    c2:  
    ret
  
    possible_directey:
    
    mov al,byte ptr tab[si]
    mov byte ptr tab[si],0
    mov byte ptr tab[bx],al 
                       
    lea dx, possibled
    mov ah, 9
    int 21h   
    mov al,0 
    ret      
 
endp

indirecte proc
    xor ax,ax
    push ax 
 popo:
    mov ax,dx  
    cmp byte ptr tab[si],1
    jnz i12 
    add dl,2
    inc al
    jmp i32
    i12:
    cmp byte ptr tab[si],3
    jnz i22
    dec al 
    sub dl,2
    jmp i32
    i22: 
    call directe_long
    cmp al,0
    jz i32
    ret 
    i32:
    
    dec ah 
    sub dh,2
       
    mov bx,dx
    call numero_case  
    mov di,bx
    cmp byte ptr tab[di],0
    jnz s11  
    
    mov bx,ax
    call numero_case   
    cmp byte ptr tab[bx],0
    jnz possible_indirecten 
     
    s11:
    add ah,2 
    add dh,4 
       
    mov bx,dx
    call numero_case  
    mov di,bx
    cmp byte ptr tab[di],0 
    jz s22
    
    ty3:     
    pop bx
    cmp bx,0
    jnz ty3
    lea dx,plein
    mov ah, 9
    int 21h
    ret
    s22: 

    mov bx,ax
    call numero_case  
    cmp byte ptr tab[bx],0
    jnz possible_indirecten 
  
    ty4:     
    pop bx
    cmp bx,0
    jnz ty4
    lea dx, interdit
    mov ah, 9
    int 21h 
    ret 
        
    possible_indirecten: 
    
    push bx
    cmp dx,cx
    jz ty1    
    jmp popo
    ty1:
    pop bx  
    mov byte ptr tab[bx],0
    cmp bx,0
    jnz ty1     
    mov al,byte ptr tab[si]  
    mov byte ptr tab[di],al
    mov byte ptr tab[si],0 
    lea dx,possiblei
    mov ah,9
    int 21h
    cmp di,5
    jbe v1
    cmp di,46
    jae v1 
    ret
    v1:    
    add byte ptr tab[di],1         
    ret 
       
endp          
ends

end start 


