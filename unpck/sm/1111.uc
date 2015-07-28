class 1111 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect2
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.su_summon_a_ca'
	End Object
	Desc="서먼 캣더캣" //Summon Kat deokaet
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect2',SpecificStage=0)
}