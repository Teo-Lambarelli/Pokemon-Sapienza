.globl main



.data

n0:.word 1
n1:.word 45
w:.byte 'c'
.text
main:

lw $t0, n0
lw $t1, n1

and $t3, $t1, $t0

#bne rs, rt, target Salta all’istruzione puntata da target se rs != rt
bne $t3, $t0 pari
j end


pari:
lb $t4, w
end:
li $v0, 10
syscall
