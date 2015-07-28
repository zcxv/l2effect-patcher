class 327 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect3
		AttachOn=AM_RA
		AttachBoneName="soulshot1"
		bAbsolute=True
		EffectClass=Class'LineageEffect.su_empower_ta'
	End Object
	Desc="와이번 이지스" //Wyvern Aegis
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect3',SpecificStage=0)
}