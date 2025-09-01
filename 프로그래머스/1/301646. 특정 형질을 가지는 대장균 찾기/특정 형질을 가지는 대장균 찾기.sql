select COUNT(*) as COUNT
from ECOLI_DATA as a
where a.GENOTYPE & 2 = 0 and (a.GENOTYPE & 1 > 0 or a.GENOTYPE & 4 > 0) ;